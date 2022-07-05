package kbe.protectioncivile.myapplicationrecrutement.api.candidature.controller
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureModel
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import retrofit2.Call
import retrofit2.http.*

interface CandidatureInterface{
    @Headers("Content-Type: application/json")
    @POST("login/forms")
    fun sendCandidature(
        @Header("Authorization") authorization: String,
        @Body candidatureData: CandidatureModel
    ): Call<CandidatureResponse>

    @GET("login/forms")
    fun getAllFormsById(
        @Header("Authorization") authorization: String
    ): Call<List<CandidatureResponse>>

    @PUT("users/{id}")
    fun updateFormById(
        @Header("Authorization") authorization: String,
        @Path("id") formId: String,
        @Body updateFormData: CandidatureModel
    ): Call<CandidatureResponse>
}