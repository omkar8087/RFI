package com.example.rfi.di

import android.content.Context
import com.example.rfi.database.RfiDao
import com.example.rfi.database.RfiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(appContext: Context): RfiDatabase {
        return RfiDatabase.getDatabase(appContext)
    }

    @Provides
    fun provideRfiDao(db: RfiDatabase): RfiDao {
        return db.rfiDao()
    }
}