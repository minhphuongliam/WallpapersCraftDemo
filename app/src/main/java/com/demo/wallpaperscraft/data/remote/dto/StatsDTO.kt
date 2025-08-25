package com.demo.wallpaperscraft.data.remote.dto
// --- Dành cho API lấy danh sách Ảnh theo Category ---

data class StatsDTO(
    val downloads: Int,
    val favorites: Int,
    val rating: Int
)