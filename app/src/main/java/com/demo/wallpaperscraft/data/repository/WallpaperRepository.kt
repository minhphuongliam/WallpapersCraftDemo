package com.demo.wallpaperscraft.data.repository

import com.demo.wallpaperscraft.data.local.entity.FavoriteEntity
import com.demo.wallpaperscraft.data.model.Category
import com.demo.wallpaperscraft.data.model.Wallpaper
import kotlinx.coroutines.flow.Flow

// Sử dụng Result class để đóng gói kết quả từ mạng
// typealias RepoResult<T> = Result<T>

interface WallpaperRepository {
    // Các hàm liên quan đến mạng
    suspend fun getCategories(): Result<List<Category>>
    suspend fun getWallpapers(
        categoryId: Int,
        sortBy: String,
        offset: Int,
        limit: Int
    ): Result<List<Wallpaper>>
    suspend fun searchWallpapers(
        query: String,
        offset: Int,
        limit: Int
    ): Result<List<Wallpaper>>

    // Các hàm cho Favorite
    fun isFavorite(imageId: Int): Flow<Boolean>
    fun getAllFavorites(): Flow<List<FavoriteEntity>>
    suspend fun addFavorite(wallpaper: Wallpaper)
    suspend fun removeFavorite(imageId: Int)

    // Thêm các hàm cho History và Collections sau ...
}