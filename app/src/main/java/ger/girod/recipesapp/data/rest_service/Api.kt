package ger.girod.recipesapp.data.rest_service

import ger.girod.recipesapp.data.rest_service.responses.RecipesResponse
import ger.girod.recipesapp.data.utils.RECIPES_DETAIL_ENDPOINT
import ger.girod.recipesapp.data.utils.RECIPES_ENDPOINT
import ger.girod.recipesapp.domain.RecipeDetailModel
import ger.girod.recipesapp.domain.RecipeModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET(RECIPES_ENDPOINT)
    suspend fun getRecipes(@Query("diet") diet : String) : RecipesResponse

    @GET(RECIPES_DETAIL_ENDPOINT)
    suspend fun getRecipeDetail(@Path("id") recipeId : Long) : RecipeDetailModel
}