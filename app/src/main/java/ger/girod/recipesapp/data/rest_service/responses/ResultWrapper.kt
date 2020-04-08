package ger.girod.recipesapp.data.rest_service.responses

sealed class ResultWrapper<out T> {

    data class Success<out T>(val value : T) : ResultWrapper<T>()
    data class ServerError(val errorMessage : String) : ResultWrapper<Nothing>()
    data class NetworkError(val  errorMessage: String) : ResultWrapper<Nothing>()

}