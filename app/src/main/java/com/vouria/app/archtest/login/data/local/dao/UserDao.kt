package com.vouria.app.archtest.login.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vouria.app.archtest.login.data.local.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getUser(): User?

    @Query("SELECT * FROM User WHERE userName=:userName AND password=:password")
    fun getUserByUserNamePass(userName: String, password: String): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

}
