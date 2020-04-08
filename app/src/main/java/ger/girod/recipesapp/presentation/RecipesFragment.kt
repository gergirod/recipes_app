package ger.girod.recipesapp.presentation

import android.os.Bundle
import ger.girod.recipesapp.data.rest_service.ApiClient
import ger.girod.recipesapp.domain.use_case.GetRecipesUseCaseImpl
import ger.girod.recipesapp.presentation.base.BaseFragment
import ger.girod.recipesapp.R

class RecipesFragment : BaseFragment() {

    override fun layoutId() = R.layout.recipes_list_fragment

    private lateinit var viewModel : RecipesViewModel

    private fun initializeViewModel() {
        viewModel = RecipesViewModel(GetRecipesUseCaseImpl(ApiClient.create()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeViewModel()
    }
}