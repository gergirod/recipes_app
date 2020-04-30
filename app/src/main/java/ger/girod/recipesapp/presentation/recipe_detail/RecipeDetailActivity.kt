package ger.girod.recipesapp.presentation.recipe_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ger.girod.recipesapp.R

class RecipeDetailActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context ,recipeId: Long) = Intent(context, RecipeDetailActivity::class.java).apply {
            putExtra(RECIPE_ID, recipeId)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)
        if(savedInstanceState == null) {

            val recipeId = intent.getLongExtra(RECIPE_ID, 0)

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecipeDetailFragment.newInstance(recipeId))
                .commitNow()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

}