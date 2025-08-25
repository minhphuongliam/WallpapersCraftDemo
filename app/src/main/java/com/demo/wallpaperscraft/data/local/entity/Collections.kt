package com.demo.wallpaperscraft.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Bảng lưu metadata cho mỗi bộ sưu tập (cho Wallpaper Changer)
@Entity(tableName = "collections")
data class CollectionEntity(
    @PrimaryKey val collectionId: String, // "category_54", "favorites"....
    val name: String,                     // "Abstract", "Favorites"
    val coverPath: String,                // URL hoặc đường dẫn cục bộ của ảnh bìa
    val lastSyncedAt: Long
)