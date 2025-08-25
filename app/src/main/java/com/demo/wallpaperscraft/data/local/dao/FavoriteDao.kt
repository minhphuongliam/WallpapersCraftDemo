package com.demo.wallpaperscraft.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.wallpaperscraft.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    // Thêm một ảnh vào danh sách yêu thích
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: FavoriteEntity)

    // Xóa một ảnh khỏi danh sách yêu thích
    @Query("DELETE FROM favorites WHERE imageId = :imageId")
    suspend fun removeFavorite(imageId: Int)

    // Kiểm tra xem một ảnh có trong danh sách yêu thích không
    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE imageId = :imageId LIMIT 1)")
    fun isFavorite(imageId: Int): Flow<Boolean>

    // Lấy toàn bộ danh sách yêu thích, sắp xếp theo thời gian thêm mới nhất
    @Query("SELECT * FROM favorites ORDER BY addedAt DESC")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>
}