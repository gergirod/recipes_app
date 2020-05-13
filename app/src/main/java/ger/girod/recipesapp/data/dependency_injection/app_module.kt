package ger.girod.recipesapp.data.dependency_injection

import ger.girod.recipesapp.data.repositories.RecipeRepository
import ger.girod.recipesapp.data.rest_service.*
import ger.girod.recipesapp.domain.use_case.provideRecipeDetailUseCase
import ger.girod.recipesapp.domain.use_case.provideRecipesUseCase
import ger.girod.recipesapp.presentation.recipe_detail.RecipeDetailViewModel
import ger.girod.recipesapp.presentation.recipes_list.RecipesViewModel
import org.koin.dsl.module

val appModule = module {

    factory { RecipeRepository(get()) }

    factory { RecipesViewModel(get()) }

    factory { RecipeDetailViewModel(get()) }

    factory { provideRecipeDetailUseCase(get()) }

    factory { provideRecipesUseCase(get()) }

    factory { provideOkHttpClient() }

    factory { provideApi(get()) }

    single { provideRetrofit(get()) }

}