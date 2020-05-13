package ger.girod.recipesapp.domain.use_case

import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.domain.RecipeDetailModel

interface GetRecipeDetailUseCase {

    suspend fun getRecipeDetail(recipeId : Long) : ResultWrapper<RecipeDetailModel>
 }