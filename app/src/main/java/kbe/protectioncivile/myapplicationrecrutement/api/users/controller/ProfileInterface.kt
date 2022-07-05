package kbe.protectioncivile.myapplicationrecrutement.api.users.controller

import kbe.protectioncivile.myapplicationrecrutement.api.candidature.model.CandidatureResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UpdateUserResponse
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserModel
import kbe.protectioncivile.myapplicationrecrutement.api.users.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ProfileInterface {
    @GET("users/{id}")
    fun getUserById(
        @Header("Authorization") authorization: String,
        @Path("id") userId: String
    ): Call<UserResponse>

    @PUT("users/{id}")
    fun updateUserById(
        @Header("Authorization") authorization: String,
        @Path("id") userId: String,
        @Body updateUserData: UserModel
    ): Call<UpdateUserResponse>

    @GET("users")
    fun getAllUsers(
        @Header("Authorization") authorization: String
    ): Call<List<UserResponse>>

    @GET("users")
    fun getAllUsersForm(
        @Header("Authorization") authorization: String
    ): Call<List<CandidatureResponse>>
}