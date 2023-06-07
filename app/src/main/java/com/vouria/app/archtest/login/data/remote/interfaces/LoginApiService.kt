package com.vouria.app.archtest.login.data.remote.interfaces

import androidx.room.Delete
import com.vouria.app.archtest.login.data.local.entity.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginApiService {

    @GET()
    fun getUser(): User?

    @GET("login")
    fun login(
        @Query("username") userName: String,
        @Query("password") password: String,
    ): Response<User>

    @POST()
    fun sendUser(user: User)

    @Delete
    fun deleteUser(user: User)

}