package kbe.protectioncivile.myapplicationrecrutement.api.authentication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class InscriptionModel(
    @Expose
    @SerializedName("firstName")
    val firstName: String,
    @Expose
    @SerializedName("lastName")
    val lastName: String,
    @Expose
    @SerializedName("email")
    val email: String,
    @Expose
    @SerializedName("password")
    val password: String
)
