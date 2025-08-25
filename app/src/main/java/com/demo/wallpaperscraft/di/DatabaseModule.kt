package com.demo.wallpaperscraft.di

import android.content.Context
import androidx.room.Room
import com.demo.wallpaperscraft.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Module hilt, cấp dependancies toàn bộ vòng đời app
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    // Tạo instance duy nhất của AppDB
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "wallpaper_app.db" // db name
        ).build()
    }

    @Provides
    fun provideFavoriteDao(appDatabase: AppDatabase) = appDatabase.favoriteDao()

    @Provides
    fun provideHistoryDao(appDatabase: AppDatabase) = appDatabase.historyDao()

    @Provides
    fun provideCollectionDao(appDatabase: AppDatabase) = appDatabase.collectionDao()
}