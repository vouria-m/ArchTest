package com.vouria.app.archtest.login.domain.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vouria.app.archtest.login.data.local.entity.User
import com.vouria.app.archtest.login.ui.NetworkResult
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    val loginResponse: LiveData<NetworkResult<User>>

    fun getUser(): User?

    fun login(userName: String, password: String)

    fun insertUser(user: User)

    fun deleteUser(user: User)

}