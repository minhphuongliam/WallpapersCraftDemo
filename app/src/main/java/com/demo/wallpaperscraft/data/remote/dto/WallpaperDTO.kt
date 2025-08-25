package com.demo.wallpaperscraft.data.remote.dto
// --- Dành cho API lấy danh sách Ảnh theo Category ---

data class WallpaperDTO(
    val id: Int,
    val author: String,
    val is_premium: Boolean,
    val tags: List<String>,
    val stats: StatsDTO,
    val uploaded_at: String,
    val versions: VersionsDTO
)