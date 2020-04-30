package ger.girod.recipesapp.presentation.recipes_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.domain.RecipeModel
import ger.girod.recipesapp.domain.use_case.GetRecipesUseCase
import ger.girod.recipesapp.presentation.base.BaseViewModel
import ger.girod.recipesapp.presentation.utils.ScreenState
import kotlinx.coroutines.launch

class RecipesViewModel(private val getRecipesUseCase: GetRecipesUseCase) : BaseViewModel() {

    var recipesData : MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun getRecipes() {
        viewModelScope.launch {
            screenSteteData.postValue(ScreenState.Loading)
            when(val  response = getRecipesUseCase.getRecipes("Vegan")) {
                is ResultWrapper.Success -> recipesData.postValue(response.value.results)
                is ResultWrapper.ServerError -> errorMessageData.postValue(response.errorMessage)
            }
            screenSteteData.postValue(ScreenState.LoadingFinish)
        }
    }

}