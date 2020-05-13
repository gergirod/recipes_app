package ger.girod.recipesapp.presentation.recipes_list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import ger.girod.recipesapp.data.rest_service.ApiClient
import ger.girod.recipesapp.domain.use_case.GetRecipesUseCaseImpl
import ger.girod.recipesapp.presentation.base.BaseFragment
import ger.girod.recipesapp.R
import kotlinx.android.synthetic.main.recipes_list_fragment.*
import androidx.recyclerview.widget.LinearLayoutManager
import ger.girod.recipesapp.domain.RecipeModel
import ger.girod.recipesapp.presentation.recipe_detail.RecipeDetailActivity
import ger.girod.recipesapp.presentation.utils.ScreenState
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesFragment : BaseFragment() , RecipesAdapter.OnRowClickListener {

    override fun layoutId() = R.layout.recipes_list_fragment

    private val adapter : RecipesAdapter by lazy {
        RecipesAdapter(this)
    }
    private val recipesViewModel : RecipesViewModel by  viewModel()


    private fun initializeViewModel() {

        recipesViewModel.recipesData.observe(this, Observer {
            adapter.setList(it as ArrayList<RecipeModel>)
        })

        recipesViewModel.screenSteteData.observe(this, Observer {
            when(it){
                ScreenState.Loading -> progress_bar.visibility = View.VISIBLE
                ScreenState.LoadingFinish -> progress_bar.visibility = View.GONE
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeList()

        recipesViewModel.getRecipes()
    }

    private fun initializeList() {

        list.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity)
        list.layoutManager = layoutManager
        list.adapter = adapter
    }

    override fun onClicked(recipeId: Long) {
        startActivity(RecipeDetailActivity.getIntent(activity!!, recipeId))
    }
}