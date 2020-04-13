package ger.girod.recipesapp.domain

data class RecipeDetailModel(
    val id : Long,
    val title : String,
    val image : String,
    val imageType : String,
    val servings : Int,
    val readyInMinutes : Int,
    val license : String,
    val sourceName : String,
    val sourceUrl : String,
    val spoonacularSourceUrl :String,
    val aggregateLike : Int,
    val healthScore : Int,
    val extendedIngredients : List<ExtendendIngredientsModel>,
    val summary : String

) {
}