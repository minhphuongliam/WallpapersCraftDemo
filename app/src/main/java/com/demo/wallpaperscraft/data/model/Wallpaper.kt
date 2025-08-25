package com.demo.wallpaperscraft.data.model
// Model chính Wallpaper để UI làm việc
data class Wallpaper(
    val id: Int,
    val author: String,
    val isPremium: Boolean,
    val price: Int, // <-- Thêm vào
    val categoryId: Int,
    val tags: List<String>,
    val stats: Stats,
    val uploadedAt: String,
    val previewUrl: String, // Giữ lại URL preview để truy cập nhanh cho grid
    val versions: List<ImageVersion> // <-- Thay thế WallpaperUrls bằng một danh sách các phiên bản
)