package kbe.protectioncivile.myapplicationrecrutement.api.authentication.model

import com.google.gson.annotations.SerializedName

data class InscriptionResponse(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("fistName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("role")
    val role: String
)
