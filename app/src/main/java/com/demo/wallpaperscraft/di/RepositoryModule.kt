package com.demo.wallpaperscraft.di

import com.demo.wallpaperscraft.data.repository.WallpaperRepository
import com.demo.wallpaperscraft.data.repository.WallpaperRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    //Khi code cần WallRepo thì phải cung cấp 1 instance của WallRepoImpl
    @Binds
    @Singleton
    abstract fun bindWallpaperRepository(
        wallpaperRepositoryImpl: WallpaperRepositoryImpl
    ): WallpaperRepository
}