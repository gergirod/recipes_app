package ger.girod.recipesapp.data.rest_service


import ger.girod.recipesapp.data.utils.API_KEY
import ger.girod.recipesapp.data.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    var logging   = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    var client : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor{ chain ->
            var request = chain.request()
            val originalUrl = request.url
            val url = originalUrl.newBuilder()
                .addQueryParameter("apiKey", API_KEY)
                .build()

            val builder = request.newBuilder()
                .url(url)

          chain.proceed(builder.build())

        }
        .build()

    fun create() : Api{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(Api::class.java)

    }
}