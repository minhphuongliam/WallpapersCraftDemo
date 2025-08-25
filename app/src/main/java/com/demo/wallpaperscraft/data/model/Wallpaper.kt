package com.demo.wallpaperscraft.data.model
// Model chính Wallpaper để UI làm việc
data class Wallpaper(
    val id: Int,
    val author: String,
    val isPremium: Boolean,
    val categoryId: Int,
    val tags: List<String>,
    val stats: Stats,
    val uploadedAt: String,
    val urls: WallpaperUrls // đã được đơn giản hóa
)