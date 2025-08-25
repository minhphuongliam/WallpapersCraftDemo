package com.demo.wallpaperscraft.data.remote.dto

// --- Dành cho API lấy danh sách Ảnh theo Category ---

data class WallpaperListResponse(
    val category_id: Int,
    val category_title: String,
    val image_count: Int,
    val items: List<WallpaperDTO>
)