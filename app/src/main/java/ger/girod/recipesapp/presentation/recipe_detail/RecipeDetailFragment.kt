package ger.girod.recipesapp.presentation.recipe_detail

import android.os.Bundle
import androidx.lifecycle.Observer
import ger.girod.recipesapp.data.rest_service.ApiClient
import ger.girod.recipesapp.domain.use_case.GetRecipeDetailUseCaseImpl
import ger.girod.recipesapp.presentation.base.BaseFragment
import ger.girod.recipesapp.R

class RecipeDetailFragment : BaseFragment() {

    private val viewModel : RecipeDetailViewModel by lazy {
        RecipeDetailViewModel(GetRecipeDetailUseCaseImpl(ApiClient.create()))
    }

    override fun layoutId() = R.layout.recipe_detail_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.screenSteteData.observe(this , Observer {

        })

        viewModel.errorMessageData.observe(this, Observer {

        })
    }
}