package com.vouria.app.archtest.login.data.remote

import com.vouria.app.archtest.login.data.local.entity.User
import com.vouria.app.archtest.login.data.remote.interfaces.LoginApiService
import com.vouria.app.archtest.login.ui.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val apiService: LoginApiService) {

    suspend fun login(userName: String, password: String): Flow<NetworkResult<User>> = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.login(userName, password)
        if (response.isSuccessful) {
            var data = response.body()
            if (data != null)
                emit(NetworkResult.Success(data))
            else
                emit(NetworkResult.Failure("body in null"))

        } else {
            emit(NetworkResult.Failure(response.errorBody()?.string() ?: "response is failure"))
        }
        emit(NetworkResult.Loading(false))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }
}