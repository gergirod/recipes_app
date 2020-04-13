package ger.girod.recipesapp.presentation.recipe_detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import coil.api.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import ger.girod.recipesapp.data.rest_service.ApiClient
import ger.girod.recipesapp.domain.use_case.GetRecipeDetailUseCaseImpl
import ger.girod.recipesapp.presentation.base.BaseFragment
import ger.girod.recipesapp.R
import ger.girod.recipesapp.domain.RecipeDetailModel
import ger.girod.recipesapp.presentation.utils.ScreenState
import kotlinx.android.synthetic.main.recipe_detail_fragment.*


const val RECIPE_ID = "recipe_id"
class RecipeDetailFragment : BaseFragment() {

    companion object {
        fun newInstance(recipeId : Long) = RecipeDetailFragment().apply{
            arguments = Bundle().apply {
                putLong(RECIPE_ID, recipeId)
            }
        }
    }

    private val viewModel : RecipeDetailViewModel by lazy {
        RecipeDetailViewModel(GetRecipeDetailUseCaseImpl(ApiClient.create()))
    }

    override fun layoutId() = R.layout.recipe_detail_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRecipeDetail(arguments!!.getLong(RECIPE_ID, 0))
    }

    private fun initViewModel() {

        viewModel.recipeDetailData.observe(this, Observer {
            populateData(it)
        })

        viewModel.screenSteteData.observe(this , Observer {
            when(it) {
                ScreenState.Loading -> progress_bar.visibility = View.VISIBLE
                ScreenState.LoadingFinish -> progress_bar.visibility = View.GONE
            }
        })

        viewModel.errorMessageData.observe(this, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun populateData(recipeDetailModel: RecipeDetailModel) {
        recipe_image.load(recipeDetailModel.image){
            scale(Scale.FILL)
            crossfade(750)
            transformations(RoundedCornersTransformation())
        }
        recipe_name.text = recipeDetailModel.title
    }
}