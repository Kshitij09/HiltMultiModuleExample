package com.kshitijpatil.data.android

import com.kshitijpatil.api.users.UsersApi
import com.kshitijpatil.data.DataState
import com.kshitijpatil.data.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val api: UsersApi
) {
    suspend fun getUsers(): Flow<DataState<List<User>>> =
        flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                val users = api.getUsers()
                emit(DataState.Success(users))
            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }
}