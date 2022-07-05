package kbe.protectioncivile.myapplicationrecrutement.api.users.model

import com.google.gson.annotations.SerializedName

data class UpdateUserResponse(
    @SerializedName("userId") val userId: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("email") val email: String
)
