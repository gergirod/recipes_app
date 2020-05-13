package ger.girod.recipesapp.data.repositories

import ger.girod.recipesapp.data.rest_service.Api
import ger.girod.recipesapp.data.rest_service.responses.RecipesResponse
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.data.rest_service.responses.executeRequest
import ger.girod.recipesapp.domain.RecipeDetailModel
import kotlinx.coroutines.Dispatchers

class RecipeRepository(private val api: Api) {


    suspend fun getRecipeList(diet : String) : ResultWrapper<RecipesResponse> {
        return executeRequest(Dispatchers.IO) {
            api.getRecipes(diet)
        }
    }

    suspend fun getRecipeDetail(recipeId : Long) : ResultWrapper<RecipeDetailModel> {
        return executeRequest(Dispatchers.IO) {
            api.getRecipeDetail(recipeId)
        }
    }

}