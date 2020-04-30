package ger.girod.recipesapp.presentation.recipe_detail

import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import coil.api.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import ger.girod.recipesapp.data.rest_service.ApiClient
import ger.girod.recipesapp.domain.use_case.GetRecipeDetailUseCaseImpl
import ger.girod.recipesapp.presentation.base.BaseFragment
import ger.girod.recipesapp.R
import ger.girod.recipesapp.domain.RecipeDetailModel
import ger.girod.recipesapp.presentation.utils.ScreenState
import kotlinx.android.synthetic.main.recipe_detail_fragment.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity






const val RECIPE_ID = "recipe_id"
class RecipeDetailFragment : BaseFragment() {

    companion object {
        fun newInstance(recipeId : Long) = RecipeDetailFragment().apply{
            arguments = Bundle().apply {
                putLong(RECIPE_ID, recipeId)
            }
        }
    }

    private val ingredientsAdapter : IngredientsAdapter by lazy {
        IngredientsAdapter()
    }

    private val viewModel : RecipeDetailViewModel by lazy {
        RecipeDetailViewModel(GetRecipeDetailUseCaseImpl(ApiClient.create()))
    }

    override fun layoutId() = R.layout.recipe_detail_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRecipeDetail(arguments!!.getLong(RECIPE_ID, 0))
        initIngredientsList()

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

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

    private fun initIngredientsList() {

        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        ingredients_list.layoutManager = layoutManager
        ingredients_list.adapter = ingredientsAdapter

    }

    private fun populateData(recipeDetailModel: RecipeDetailModel) {
        recipe_image.load(recipeDetailModel.image){
            scale(Scale.FIT)
            crossfade(750)
            transformations(CircleCropTransformation())
        }
        recipe_name.text = recipeDetailModel.title
        about_food_text.text = Html.fromHtml(recipeDetailModel.summary)
        portion_text.text = recipeDetailModel.getServingString()
        time_text.text = recipeDetailModel.getReadyInString()
        ingredientsAdapter.setList(recipeDetailModel.extendedIngredients)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
               activity?.finish()
            }

        }
        return true
    }
}