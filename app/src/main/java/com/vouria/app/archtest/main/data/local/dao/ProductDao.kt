package com.vouria.app.archtest.main.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vouria.app.archtest.main.data.local.entity.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun getAllProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

}