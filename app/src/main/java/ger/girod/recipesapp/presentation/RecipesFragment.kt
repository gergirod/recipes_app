package ger.girod.recipesapp.presentation

import androidx.fragment.app.Fragment
import ger.girod.recipesapp.data.rest_service.ApiClient
import ger.girod.recipesapp.domain.use_case.GetRecipesUseCaseImpl

class RecipesFragment : Fragment() {

    private lateinit var viewModel : RecipesViewModel

    private fun initializeViewModel() {
        viewModel = RecipesViewModel(GetRecipesUseCaseImpl(ApiClient.create()))
    }

}