package kbe.protectioncivile.myapplicationrecrutement.api.authentication.controller

import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.LoginModel
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthenticationInterface {
    @Headers("Content-Type: application/json")
    @POST("users/sign-in")
    fun login(@Body loginData: LoginModel): Call<TokenResponse>
}