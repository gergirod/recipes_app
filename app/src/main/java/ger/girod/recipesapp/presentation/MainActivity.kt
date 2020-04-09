package ger.girod.recipesapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ger.girod.recipesapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RecipesFragment())
                .commitNow()
        }
    }
}
