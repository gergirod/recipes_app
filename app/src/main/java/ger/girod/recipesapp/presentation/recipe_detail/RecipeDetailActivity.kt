package ger.girod.recipesapp.presentation.recipe_detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ger.girod.recipesapp.R

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecipeDetailFragment())
                .commitNow()
        }
    }

}