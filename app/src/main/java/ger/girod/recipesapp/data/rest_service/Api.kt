package ger.girod.recipesapp.data.rest_service

import ger.girod.recipesapp.data.rest_service.responses.RecipesResponse
import ger.girod.recipesapp.data.utils.RECIPES_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(RECIPES_ENDPOINT)
    suspend fun getRecipes(@Query("diet") diet : String) : RecipesResponse
}