package ger.girod.recipesapp.presentation.recipe_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ger.girod.recipesapp.domain.ExtendendIngredientsModel
import ger.girod.recipesapp.R

class IngredientsAdapter : RecyclerView.Adapter<IngredientsRow>() {

    var ingredientsList : ArrayList<ExtendendIngredientsModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsRow {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredients_row, parent, false)
        return IngredientsRow(view)
    }

    override fun getItemCount(): Int {
        return  ingredientsList.size
    }

    override fun onBindViewHolder(holder: IngredientsRow, position: Int) {
        holder.populateContent(ingredientsList[position])
    }

    fun setList(ingredientsLit : List<ExtendendIngredientsModel>) {

        this.ingredientsList.clear();
        this.ingredientsList.addAll(ingredientsLit)
        notifyDataSetChanged()
    }
}