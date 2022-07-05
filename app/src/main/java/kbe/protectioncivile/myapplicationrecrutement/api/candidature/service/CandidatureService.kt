package kbe.protectioncivile.myapplicationrecrutement.api.candidature.service
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.controller.CandidatureInterface
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureModel
import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import kbe.protectioncivile.myapplicationrecrutement.api.provider.ApiClient
import retrofit2.Call
import retrofit2.Callback

class CandidatureService {

    fun sendCandidature(authorization: String, candidatureData: CandidatureModel, callback: Callback<CandidatureResponse>) {
        val call: Call<CandidatureResponse> = ApiClient.buildService(CandidatureInterface::class.java)
            .sendCandidature("Bearer $authorization",candidatureData)
       call.enqueue(callback)
    }

   fun GetAllCandidaturesByID(authorization: String,callback: Callback<List<CandidatureResponse>>) {
        val call: Call<List<CandidatureResponse>> = ApiClient.buildService(CandidatureInterface::class.java).getAllFormsById("Bearer $authorization")
        call.enqueue(callback)
    }
}

