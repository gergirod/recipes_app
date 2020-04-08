package ger.girod.recipesapp.domain.use_case

import ger.girod.recipesapp.data.rest_service.Api
import ger.girod.recipesapp.data.rest_service.responses.RecipesResponse
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.data.rest_service.responses.executeRequest
import kotlinx.coroutines.Dispatchers

class GetRecipesUseCaseImpl(private val api: Api) : GetRecipesUseCase {

    override suspend fun getRecipes(diet: String): ResultWrapper<RecipesResponse> {
        return executeRequest(Dispatchers.IO) {
            api.getRecipes(diet)
        }
    }
}