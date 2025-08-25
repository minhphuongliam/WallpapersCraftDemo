package com.demo.wallpaperscraft.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Bảng lưu lịch sử các ảnh đã được đặt làm hình nền
@Entity(tableName = "history")
data class HistoryEntity(
    @PrimaryKey val imageId: Int,
    val localPath: String, // Lưu đường dẫn file cục bộ
    val setAt: Long
)