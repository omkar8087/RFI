package com.example.rfi.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class RfiDatabase : RoomDatabase(){
    abstract fun rfiDao(): RfiDao

    companion object {
        @Volatile
        private var INSTANCE: RfiDatabase? = null

        fun getDatabase(context: Context): RfiDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RfiDatabase::class.java,
                    "rfi_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}