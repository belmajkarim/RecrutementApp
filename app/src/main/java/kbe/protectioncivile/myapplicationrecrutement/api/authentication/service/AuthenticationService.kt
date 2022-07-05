package kbe.protectioncivile.myapplicationrecrutement.api.authentication.service

import kbe.protectioncivile.myapplicationrecrutement.api.authentication.controller.AuthenticationInterface
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.LoginModel
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.TokenResponse
import kbe.protectioncivile.myapplicationrecrutement.api.provider.ApiClient
import retrofit2.Call
import retrofit2.Callback

class  AuthenticationService {

    fun login(loginData: LoginModel, callback: Callback<TokenResponse>) {
        val call: Call<TokenResponse> = ApiClient.buildService(AuthenticationInterface::class.java).login(loginData)
        call.enqueue(callback)
    }

}
