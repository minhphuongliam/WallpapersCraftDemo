package com.demo.wallpaperscraft.data.remote.api

import com.demo.wallpaperscraft.data.remote.dto.CategoryListResponse
import com.demo.wallpaperscraft.data.remote.dto.WallpaperListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperApiService {
    @GET("path/to/categories.json")
    suspend fun getCategories(): CategoryListResponse

    @GET("path/to/wallpapers") // Giả sử Cloud Function URL
    suspend fun getWallpapers(
        @Query("category_id") categoryId: Int,
        @Query("sort") sortBy: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("screen_width") screenWidth: Int,
        @Query("screen_height") screenHeight: Int,
        @Query("types") types: List<String> // <-- THÊM VÀO: Ví dụ: ["free", "premium"]
    ): WallpaperListResponse

    // Đã cập nhật: Thêm đầy đủ tham số
    @GET("path/to/search")
    suspend fun searchWallpapers(
        @Query("query") query: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("screen_width") screenWidth: Int,
        @Query("screen_height") screenHeight: Int,
        @Query("types") types: List<String>
    ): WallpaperListResponse // Giả sử API search trả về cùng cấu trúc
}