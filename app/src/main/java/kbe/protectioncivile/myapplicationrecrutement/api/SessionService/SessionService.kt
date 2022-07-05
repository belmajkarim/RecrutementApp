package kbe.protectioncivile.myapplicationrecrutement.api.SessionService

import android.content.Context


import kbe.protectioncivile.myapplicationrecrutement.api.provider.AppPreferences
import kbe.protectioncivile.myapplicationrecrutement.LoginActivity
import kbe.protectioncivile.myapplicationrecrutement.api.token.TokenResponse


class SessionService {

    fun deleteToken() {
        AppPreferences.clear("token")
    }
    fun deleteEmail() {
        AppPreferences.clear("email")
    }

    fun deleteId() {
        AppPreferences.clear("id")
    }
    fun setIsLoginToFalse() {
        AppPreferences.isLogin = false
    }

    fun retrieveUserInfoViaToken(token: String): TokenResponse {
        val tokenResponse = kbe.protectioncivile.myapplicationrecrutement.api.token.JWTUtils.decoded(token);
        return tokenResponse;
    }

    /*fun testUserToken(userToken: String): Boolean {
        val tokenResponse: TokenResponse = retrieveUserInfoViaToken(userToken);

        var isValid: Boolean = false

        if (tokenResponse.Id == "" || tokenResponse.name == "") {
            deleteToken()
            deleteEmail()
            deleteId()
            setIsLoginToFalse()

            return isValid
        } else {
            //val email = tokenResponse.email
            val profileService = ProfileService();

            profileService.getUserByID(userToken, email, object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    if (response.body() == null){
                        deleteToken()
                        isValid = false
                    } else {
                        AppPreferences.token = userToken
                        AppPreferences.email = response.body()?.email.toString()
                        AppPreferences.id = response.body()?.id.toString()
                        AppPreferences.isLogin = true
                        isValid = true
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    deleteToken()
                    isValid = false
                }
            })
        }
        return isValid;
    }*/

    fun disconnect(context: Context) {
        deleteToken()
        deleteEmail()
        deleteId()
        setIsLoginToFalse()
        LoginActivity.navigateTo(context)
    }
}