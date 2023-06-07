package com.vouria.app.archtest.login.data.local

import com.vouria.app.archtest.login.data.local.dao.UserDao
import com.vouria.app.archtest.login.data.local.entity.User
import javax.inject.Inject

class LocalDataSource @Inject constructor(val userDao: UserDao) {

    fun getUser(): User? {
        return userDao.getUser()
    }

    fun getUserByUserNamePass(userName: String, password: String): User? {
        return userDao.getUserByUserNamePass(userName, password)
    }

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}