package com.demo.wallpaperscraft.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Bảng liên kết các ảnh với một bộ sưu tập cụ thể
// Update dùng cặp imageId và collectionId làm khóa
@Entity(tableName = "image_collection", primaryKeys = ["imageId", "collectionId"])
data class ImageCollectionEntity(
    val imageId: Int,
    val collectionId: String,
    val remoteUrl: String,
    var localPath: String? = null,
    var isInCurrentSet: Boolean = false
)