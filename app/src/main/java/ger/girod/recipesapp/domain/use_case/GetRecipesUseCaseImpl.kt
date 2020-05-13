package ger.girod.recipesapp.domain.use_case

import ger.girod.recipesapp.data.repositories.RecipeRepository
import ger.girod.recipesapp.data.rest_service.responses.RecipesResponse
import ger.girod.recipesapp.data.rest_service.responses.ResultWrapper

fun provideRecipesUseCase(repository: RecipeRepository) : GetRecipesUseCase {
    return GetRecipesUseCaseImpl(repository)
}

class GetRecipesUseCaseImpl(private val recipeRepository: RecipeRepository) : GetRecipesUseCase {

    override suspend fun getRecipes(diet: String): ResultWrapper<RecipesResponse> {
        return recipeRepository.getRecipeList(diet)
    }
}