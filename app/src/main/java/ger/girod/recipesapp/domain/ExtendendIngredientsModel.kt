package ger.girod.recipesapp.domain

import ger.girod.recipesapp.data.utils.INGREDIENTS_IMAGE

data class ExtendendIngredientsModel(
    val aisle : String,
    val amount : Double,
    val consistency : String,
    val id : Long,
    val image : String,
    val name : String,
    val original : String,
    val unit : String
) {

    fun getIngredientImage() : String {
        return INGREDIENTS_IMAGE+image
    }
}