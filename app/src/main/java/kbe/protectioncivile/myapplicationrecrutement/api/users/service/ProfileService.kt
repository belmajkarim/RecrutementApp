package kbe.protectioncivile.myapplicationrecrutement.api.users.service

import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.controller.ProfileInterface
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UpdateUserResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserModel
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserResponse
import kbe.protectioncivile.myapplicationrecrutement.api.provider.ApiClient
import retrofit2.Callback

class ProfileService {
    fun getUserByID(authorization: String, userID: String, callback: Callback<UserResponse>) {
        val call = ApiClient.buildService(ProfileInterface::class.java).getUserById("Bearer $authorization",userID);
        call.enqueue(callback)
    }
    fun UpdateUserByID(authorization: String, userID: String, userModel: UserModel, callback: Callback<UpdateUserResponse>) {
        val call = ApiClient.buildService(ProfileInterface::class.java).updateUserById("Bearer $authorization",userID,userModel);
        call.enqueue(callback)
    }
    fun GetAllUsers(authorization: String, callback: Callback<List<UserResponse>>) {
        val call = ApiClient.buildService(ProfileInterface::class.java).getAllUsers("Bearer $authorization");
        call.enqueue(callback)
    }
    fun GetAllUsersForm(authorization: String, callback: Callback<List<CandidatureResponse>>) {
        val call = ApiClient.buildService(ProfileInterface::class.java).getAllUsersForm("Bearer $authorization");
        call.enqueue(callback)
    }
}