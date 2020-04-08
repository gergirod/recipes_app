package ger.girod.recipesapp.domain.use_case

import ger.girod.recipesapp.data.rest_service.responses.RecipesResponse
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper

interface GetRecipesUseCase {

    suspend fun getRecipes(diet: String) : ResultWrapper<RecipesResponse>
}