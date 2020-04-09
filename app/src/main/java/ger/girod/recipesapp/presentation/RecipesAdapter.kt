package ger.girod.recipesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ger.girod.recipesapp.R
import ger.girod.recipesapp.domain.RecipeModel

class RecipesAdapter : RecyclerView.Adapter<ItemRow>() {

    private var list : ArrayList<RecipeModel> = ArrayList()

    fun setList(list: ArrayList<RecipeModel>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRow {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipes_row, parent, false)
        return ItemRow(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemRow, position: Int) {
        val recipeModel = list[position]
        holder.populateContent(recipeModel)
    }
}