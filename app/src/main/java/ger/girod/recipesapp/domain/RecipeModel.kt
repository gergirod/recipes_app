package ger.girod.recipesapp.domain

import ger.girod.recipesapp.data.utils.RECIPES_IMAGES

data class RecipeModel(val id : Long, val image : String,
                       val readyInMinutes : Int, val servings : Int,
                       val title : String) {

    fun getImageUrl() : String {
        return RECIPES_IMAGES+image
    }

    fun getReadyInString() : String {
        return "$readyInMinutes minutes"
    }

    fun getServingString() : String {
        return  "$servings portion"
    }
}