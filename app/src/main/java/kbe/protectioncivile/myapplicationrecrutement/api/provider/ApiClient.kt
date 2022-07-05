package kbe.protectioncivile.myapplicationrecrutement.api.provider

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL: String = "http://10.0.2.2:8080/"

    //private var token = AppPreferences.Token
    private var retrofit: Retrofit? = null
    private var httpClient = OkHttpClient.Builder()
        .build()/*.addInterceptor{ chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder().header("Authorization","Bearer $token")
        val request = requestBuilder.build()
        chain.proceed(request)*/


    fun <T> buildService(service: Class<T>): T {

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient).build()

        return retrofit?.create(service)!!
    }

}
/*object ApiClient {
    private lateinit var apiService: AuthenticationService
    private val BASE_URL: String = "http://10.0.2.2:8080/"
    fun getApiService(context: Context): AuthenticationService {

        // Initialize ApiService if not initialized yet
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient(context)) // Add our Okhttp client
                .build()

            apiService = retrofit.create(AuthenticationService::class.java)
        }

        return apiService
    }

    /**
     * Initialize OkhttpClient with our interceptor
     */
    fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }


}*/