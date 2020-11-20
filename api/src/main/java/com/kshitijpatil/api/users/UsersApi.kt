package com.kshitijpatil.api.users

import com.kshitijpatil.data.User
import retrofit2.http.GET

interface UsersApi {
    @GET("users")
    suspend fun getUsers(): List<User>

}