package com.vouria.app.archtest.login.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val userName: String,
    val password: String,
    val age: Int,
)
