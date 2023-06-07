package com.vouria.app.archtest.login.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vouria.app.archtest.login.data.local.LocalDataSource
import com.vouria.app.archtest.login.data.local.entity.User
import com.vouria.app.archtest.login.data.remote.RemoteDataSource
import com.vouria.app.archtest.login.domain.repository.IUserRepository
import com.vouria.app.archtest.login.ui.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRepository @Inject constructor(val remote: RemoteDataSource, val local: LocalDataSource) :
    IUserRepository {

    private var _loginResponse = MutableLiveData<NetworkResult<User>>()
    override val loginResponse: LiveData<NetworkResult<User>> = _loginResponse


    override fun getUser(): User? {
        return remote.apiService.getUser()
    }

    override fun login(userName: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            remote.login(userName, password).collect {
                _loginResponse.postValue(it)
            }
        }
    }

    override fun insertUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }
}