package ger.girod.recipesapp.domain.use_case

import ger.girod.recipesapp.data.repositories.RecipeRepository
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper
import ger.girod.recipesapp.domain.RecipeDetailModel

fun provideRecipeDetailUseCase(repository: RecipeRepository) : GetRecipeDetailUseCase {
    return GetRecipeDetailUseCaseImpl(repository)
}

class GetRecipeDetailUseCaseImpl(private val repository: RecipeRepository) : GetRecipeDetailUseCase {

    override suspend fun getRecipeDetail(recipeId: Long): ResultWrapper<RecipeDetailModel> {
        return repository.getRecipeDetail(recipeId)
    }
}