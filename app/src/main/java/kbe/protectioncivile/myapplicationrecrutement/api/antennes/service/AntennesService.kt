package kbe.protectioncivile.myapplicationrecrutement.api.antennes.service

import kbe.protectioncivile.myapplicationrecrutement.api.antennes.controller.AntennesInterface
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesModel
import kbe.protectioncivile.myapplicationrecrutement.api.antennes.model.AntennesResponse
import kbe.protectioncivile.myapplicationrecrutement.api.provider.ApiClient
import retrofit2.Call
import retrofit2.Callback

class AntennesService {
    fun CreateAntenne(authorization: String, antennesData: AntennesModel, callback: Callback<AntennesResponse>) {
        val call: Call<AntennesResponse> = ApiClient.buildService(AntennesInterface::class.java).CreateAntenne("Bearer $authorization", antennesData)
        call.enqueue(callback)
    }
    fun GetAllAntennes(authorization: String,callback: Callback<List<AntennesResponse>>) {
        val call: Call<List<AntennesResponse>> = ApiClient.buildService(AntennesInterface::class.java).getAllAntennes("Bearer $authorization")
        call.enqueue(callback)
    }
}