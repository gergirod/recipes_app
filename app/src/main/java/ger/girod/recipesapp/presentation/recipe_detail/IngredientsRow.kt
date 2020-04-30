package ger.girod.recipesapp.presentation.recipe_detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import ger.girod.recipesapp.domain.ExtendendIngredientsModel
import kotlinx.android.synthetic.main.ingredients_row.view.*

class IngredientsRow(itemView : View) : RecyclerView.ViewHolder(itemView) {


    fun populateContent(ingredient : ExtendendIngredientsModel) {

        itemView.ingredient_image.load(ingredient.getIngredientImage()) {
            crossfade(750)
            transformations(CircleCropTransformation())
        }

        itemView.ingredient_name.text = ingredient.name
        itemView.ingredient_amount.text = ingredient.amount.toString()+' '+ingredient.unit

    }

}