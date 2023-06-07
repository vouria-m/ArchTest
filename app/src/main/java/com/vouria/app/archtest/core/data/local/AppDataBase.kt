package com.vouria.app.archtest.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vouria.app.archtest.login.data.local.dao.UserDao
import com.vouria.app.archtest.login.data.local.entity.User
import com.vouria.app.archtest.main.data.local.dao.ProductDao
import com.vouria.app.archtest.main.data.local.entity.Product

@Database(entities = [User::class, Product::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java, "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}