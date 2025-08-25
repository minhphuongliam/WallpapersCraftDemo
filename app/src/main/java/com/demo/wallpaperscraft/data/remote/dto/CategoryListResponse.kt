package com.demo.wallpaperscraft.data.remote.dto
// --- Dành cho API lấy danh sách Category ---
data class CategoryListResponse(
    val count: Int,
    val items: List<CategoryDTO>
)