package ger.girod.recipesapp.presentation

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

class RecipesFragment : BaseFragment() {

    override fun layoutId() = R.layout.recipes_list_fragment

    private lateinit var viewModel : RecipesViewModel
    private val adapter : RecipesAdapter by lazy {
        RecipesAdapter()
    }

    private fun initializeViewModel() {
        viewModel = RecipesViewModel(GetRecipesUseCaseImpl(ApiClient.create()))

        viewModel.recipesData.observe(this, Observer {
            adapter.setList(it as ArrayList<RecipeModel>)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeList()

        viewModel.getRecipes()
    }

    private fun initializeList() {

        list.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity)
        list.layoutManager = layoutManager
        list.adapter = adapter

    }
}