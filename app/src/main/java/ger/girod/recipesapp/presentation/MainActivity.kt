package ger.girod.recipesapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ger.girod.recipesapp.R
import ger.girod.recipesapp.data.rest_service.ApiClient
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.domain.use_case.GetRecipesUseCaseImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch {
            val useCase = GetRecipesUseCaseImpl(ApiClient.create())
            when (val  response = useCase.getRecipes("Vegan")) {

                is ResultWrapper.Success -> {
                    Log.e("mirar aca ","mirar aca es success ${response.value.totalResults}")
                }
                is ResultWrapper.ServerError -> {
                    Log.e("mirar aca ","mirar aca ${response.errorMessage}")
                }

            }
        }
    }
}
