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

    fun disconnect(context: Context) {
        deleteToken()
        deleteEmail()
        deleteId()
        setIsLoginToFalse()
        LoginActivity.navigateTo(context)
    }
}