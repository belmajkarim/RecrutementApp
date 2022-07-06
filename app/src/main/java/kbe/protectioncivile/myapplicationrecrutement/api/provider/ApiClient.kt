package kbe.protectioncivile.myapplicationrecrutement.api.provider

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    //URL PROD
    //private const val BASE_URL: String = "https://recrutement-api.herokuapp.com/"
    //URL Local
    private const val BASE_URL: String = "http://10.0.2.2:8080/"

    private var retrofit: Retrofit? = null
    private var httpClient = OkHttpClient.Builder()
        .build()


    fun <T> buildService(service: Class<T>): T {

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient).build()

        return retrofit?.create(service)!!
    }
}
