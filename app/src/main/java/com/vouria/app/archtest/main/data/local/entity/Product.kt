package com.vouria.app.archtest.main.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Product(
    @PrimaryKey val id: Long,
    val name: String,
    val description: String,
    val price: String,
    val code: String,

    )
