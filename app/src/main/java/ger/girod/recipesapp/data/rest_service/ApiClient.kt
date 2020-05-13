package ger.girod.recipesapp.data.rest_service


import ger.girod.recipesapp.data.utils.API_KEY
import ger.girod.recipesapp.data.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val logging   = run {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.apply {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
}

val client : OkHttpClient = OkHttpClient.Builder()
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


fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient() : OkHttpClient {
    return client
}


fun provideApi(retrofit: Retrofit) : Api = retrofit.create(Api::class.java)

