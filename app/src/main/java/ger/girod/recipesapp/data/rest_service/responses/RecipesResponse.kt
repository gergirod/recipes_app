package ger.girod.recipesapp.data.rest_service.responses

import ger.girod.recipesapp.domain.RecipeModel

data class RecipesResponse(val offset : Int, val number : Int,
                           val results : List<RecipeModel>, val totalResults : Int) {
}