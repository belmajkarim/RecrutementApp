package kbe.protectioncivile.myapplicationrecrutement.api.users.model

import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import com.google.gson.annotations.SerializedName

open class UserResponse (
    @SerializedName("userId") val userId: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("forms") val forms:List<CandidatureResponse>
)