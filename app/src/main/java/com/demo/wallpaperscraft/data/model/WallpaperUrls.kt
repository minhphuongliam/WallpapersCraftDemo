package com.demo.wallpaperscraft.data.model
// Chứa Url đã được xử lý , có thể fetch thẳng GLide
data class WallpaperUrls(
    val preview: String,
    val display: String, // Có thể là FHD hoặc UHD
    val full: String     // Luôn là chất lượng cao nhất (UHD)
)