package kbe.protectioncivile.myapplicationrecrutement.api.authentication.controller


import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.InscriptionModel
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.InscriptionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface InscriptionInterface {
    @Headers("Content-Type: application/json")
    @POST("users/sign-up")
    fun inscription(@Body inscriptionData: InscriptionModel): Call<InscriptionResponse>
}