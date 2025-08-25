package com.demo.wallpaperscraft.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Bảng lưu các ảnh người dùng yêu thích
@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey val imageId: Int,
    val previewUrl: String,
    val addedAt: Long
)
