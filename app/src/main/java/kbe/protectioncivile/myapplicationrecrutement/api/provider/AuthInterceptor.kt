package kbe.protectioncivile.myapplicationrecrutement.api.provider

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request

        requestBuilder.addHeader("Authorization", "Bearer ${AppPreferences.Token}")


        return chain.proceed(requestBuilder.build())
    }
}