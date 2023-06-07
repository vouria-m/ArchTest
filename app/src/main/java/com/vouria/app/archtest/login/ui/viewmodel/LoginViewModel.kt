package com.vouria.app.archtest.login.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.vouria.app.archtest.core.base.BaseViewModel
import com.vouria.app.archtest.login.data.local.entity.User
import com.vouria.app.archtest.login.data.repository.UserRepository
import com.vouria.app.archtest.login.domain.repository.IUserRepository
import com.vouria.app.archtest.login.ui.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: IUserRepository) :
    BaseViewModel() {


    val loginResponse: LiveData<NetworkResult<User>> = userRepository.loginResponse

    fun login(userName: String, password: String) {
            userRepository.login(userName, password)
    }
}