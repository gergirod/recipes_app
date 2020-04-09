package ger.girod.recipesapp.domain

data class ExtendendIngredientsModel(
    val aisle : String,
    val amount : Double,
    val consistency : String,
    val id : Long,
    val image : String,
    val measures : List<MeasuresModel>,
    val name : String,
    val original : String,
    val unit : String
) {
}