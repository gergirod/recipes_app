package ger.girod.recipesapp.domain

data class RecipeModel(val id : Long, val image : String,
                       val readyInMinutes : Int, val serving : Int,
                       val title : String) {
}