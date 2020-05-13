package ger.girod.recipesapp.presentation.recipe_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.domain.RecipeDetailModel
import ger.girod.recipesapp.domain.use_case.GetRecipeDetailUseCase
import ger.girod.recipesapp.presentation.base.BaseViewModel
import ger.girod.recipesapp.presentation.utils.ScreenState
import kotlinx.coroutines.launch

class RecipeDetailViewModel(private val getRecipeDetailUseCase: GetRecipeDetailUseCase) : BaseViewModel() {

    var recipeDetailData : MutableLiveData<RecipeDetailModel> = MutableLiveData()

    fun getRecipeDetail(id : Long) {
        viewModelScope.launch {
            screenSteteData.postValue(ScreenState.Loading)
            when(val response = getRecipeDetailUseCase.getRecipeDetail(id)) {
                is ResultWrapper.Success -> recipeDetailData.postValue(response.value)
                is ResultWrapper.ServerError -> errorMessageData.postValue(response.errorMessage)
            }
            screenSteteData.postValue(ScreenState.LoadingFinish)
        }
    }

}