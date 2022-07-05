package kbe.protectioncivile.myapplicationrecrutement.api.authentication.service

import kbe.protectioncivile.myapplicationrecrutement.api.authentication.controller.InscriptionInterface
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.InscriptionModel
import kbe.protectioncivile.myapplicationrecrutement.api.authentication.model.InscriptionResponse
import kbe.protectioncivile.myapplicationrecrutement.api.provider.ApiClient
import retrofit2.Call
import retrofit2.Callback

class InscriptionService {
    fun inscription(inscriptionData: InscriptionModel, callback: Callback<InscriptionResponse>) {
        val call: Call<InscriptionResponse> = ApiClient.buildService(InscriptionInterface::class.java).inscription(inscriptionData)
        call.enqueue(callback)
    }
}