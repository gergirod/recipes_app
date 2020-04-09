package ger.girod.recipesapp.domain.use_case

import ger.girod.recipesapp.data.rest_service.Api
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.data.rest_service.responses.executeRequest
import ger.girod.recipesapp.domain.RecipeDetailModel
import kotlinx.coroutines.Dispatchers

class GetRecipeDetailUseCaseImpl(val api: Api) : GetRecipeDetailUseCase {

    override suspend fun getRecipieDetail(recipeId: Long): ResultWrapper<RecipeDetailModel> {
        return executeRequest(Dispatchers.IO) {
            api.getRecipeDetail(recipeId)
        }
    }
}