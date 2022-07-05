package kbe.protectioncivile.myapplicationrecrutement.api.antennes.controller

import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesModel
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesResponse
import retrofit2.Call
import retrofit2.http.*

interface AntennesInterface {
    @Headers("Content-Type: application/json")
    @POST("login/antennes")
    fun CreateAntenne(
        @Header("Authorization") authorization: String,
        @Body antennesData: AntennesModel
    ): Call<AntennesResponse>


    @GET("login/antennes")
    fun getAllAntennes(
        @Header("Authorization") authorization: String
    ): Call<List<AntennesResponse>>
}