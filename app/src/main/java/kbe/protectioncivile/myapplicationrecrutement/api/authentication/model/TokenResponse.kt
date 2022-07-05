package kbe.protectioncivile.myapplicationrecrutement.api.authentication.model

import com.google.gson.annotations.SerializedName


data class TokenResponse(
    @SerializedName("role")
    val role: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("Token")
    val Token: String,
    @SerializedName("Id")
    val Id: String
)
