package ger.girod.recipesapp.presentation.recipes_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import ger.girod.recipesapp.domain.RecipeModel
import kotlinx.android.synthetic.main.recipes_row.view.*

class ItemRow(itemView : View, val onRowClickListener: RecipesAdapter.OnRowClickListener) : RecyclerView.ViewHolder(itemView) {

    fun populateContent(recipeModel: RecipeModel) {
        itemView.recipe_image.load(recipeModel.getImageUrl()) {
            crossfade(750)
            transformations(CircleCropTransformation())
            scale(Scale.FIT)
        }
        itemView.recipe_name.text = recipeModel.title
        itemView.time_text.text = recipeModel.getReadyInString()
        itemView.portion_text.text = recipeModel.getServingString()

        itemView.setOnClickListener {
            onRowClickListener.onClicked(recipeModel.id)
        }
    }

}