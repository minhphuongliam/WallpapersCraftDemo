package com.demo.wallpaperscraft.data.repository

import com.demo.wallpaperscraft.data.local.dao.CollectionDao
import com.demo.wallpaperscraft.data.local.dao.FavoriteDao
import com.demo.wallpaperscraft.data.local.dao.HistoryDao
import com.demo.wallpaperscraft.data.local.entity.FavoriteEntity
import com.demo.wallpaperscraft.data.model.Category
import com.demo.wallpaperscraft.data.model.Stats
import com.demo.wallpaperscraft.data.model.Wallpaper
import com.demo.wallpaperscraft.data.model.WallpaperUrls
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallpaperRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao,
    private val historyDao: HistoryDao,
    private val collectionDao: CollectionDao
    // Tạm thời chưa cần ApiService
)  : WallpaperRepository {

    // --- MOCK DATA SECTION ---
    private val mockCategoryList = listOf(
        Category(1, "3D", "https://images.wallpaperscraft.com/image/single/1413868_1920x1080.jpg"),
        Category(54, "Abstract", "https://images.wallpaperscraft.com/image/single/1426259_1920x1080.jpg"),
        Category(55, "Animals", "https://images.wallpaperscraft.com/image/single/1427671_1920x1080.jpg"),
        Category(56, "Anime", "https://images.wallpaperscraft.com/image/single/136273_1920x1920.jpg"),
        Category(65, "Art", "https://images.wallpaperscraft.com/image/single/1427434_1920x1080.jpg"),
        Category(68, "Black", "https://images.wallpaperscraft.com/image/single/1426297_1920x1080.jpg"),
        Category(191, "Black and white", "https://images.wallpaperscraft.com/image/single/1423606_1920x1080.jpg"),
        Category(34, "Cars", "https://images.wallpaperscraft.com/image/single/1427549_1920x1080.jpg"),
        Category(35, "City", "https://images.wallpaperscraft.com/image/single/1427307_1920x1080.jpg"),
        Category(66, "Dark", "https://images.wallpaperscraft.com/image/single/1427530_1920x1080.jpg"),
        Category(36, "Fantasy", "https://images.wallpaperscraft.com/image/single/341247_1920x1080.jpg"),
        Category(37, "Flowers", "https://images.wallpaperscraft.com/image/single/1427553_1920x1080.jpg"),
        Category(38, "Food", "https://images.wallpaperscraft.com/image/single/1427531_1920x1080.jpg"),
        Category(40, "Girls", "https://images.wallpaperscraft.com/image/single/1423678_1920x1080.jpg"),
        Category(42, "Holidays", "https://images.wallpaperscraft.com/image/single/1375646_1920x1080.jpg"),
        Category(60, "Love", "https://images.wallpaperscraft.com/image/single/1421873_1920x1080.jpg"),
        Category(43, "Macro", "https://images.wallpaperscraft.com/image/single/1426444_1920x1080.jpg"),
        Category(44, "Men", "https://images.wallpaperscraft.com/image/single/1185517_1920x1080.jpg"),
        Category(61, "Minimalism", "https://images.wallpaperscraft.com/image/single/1427380_1920x1080.jpg"),
        Category(64, "Motorcycles", "https://images.wallpaperscraft.com/image/single/1335604_1920x1080.jpg"),
        Category(46, "Music", "https://images.wallpaperscraft.com/image/single/1420253_1920x1080.jpg"),
        Category(47, "Nature", "https://images.wallpaperscraft.com/image/single/1427443_1920x1080.jpg"),
        Category(48, "Other", "https://images.wallpaperscraft.com/image/single/1427536_1920x1080.jpg"),
        Category(49, "Space", "https://images.wallpaperscraft.com/image/single/1425912_1920x1080.jpg"),
        Category(51, "Sport", "https://images.wallpaperscraft.com/image/single/1422404_1920x1080.jpg"),
        Category(41, "Technologies", "https://images.wallpaperscraft.com/image/single/1421889_1920x1080.jpg"),
        Category(52, "Textures", "https://images.wallpaperscraft.com/image/single/1424156_1920x1080.jpg"),
        Category(59, "Vector", "https://images.wallpaperscraft.com/image/single/1394800_1920x1080.jpg"),
        Category(63, "Words", "https://images.wallpaperscraft.com/image/single/1427355_1920x1080.jpg")
    )
    // TRIỂN KHAI CÁC HÀM MẠNG
    override suspend fun getCategories(): Result<List<Category>> {
        delay(500) // Giả lập độ trễ mạng
        return Result.success(mockCategoryList)
    }

    override suspend fun getWallpapers(categoryId: Int, sortBy: String, offset: Int, limit: Int): Result<List<Wallpaper>> {
        delay(1000)

        // Tìm cover_url từ danh sách mock để làm ảnh đại diện cho toàn bộ list giả lập
        val representativeImageUrl = mockCategoryList.find { it.id == categoryId }?.coverUrl
            ?: "https://images.wallpaperscraft.com/image/single/136273_1920x1920.jpg" // Fallback

        val totalMockWallpapers = (0 until 100).map { index ->
            val imageId = categoryId * 1000 + index
            Wallpaper(
                id = imageId,
                author = "Mock Author ($sortBy)",
                isPremium = index % 5 == 0,
                categoryId = categoryId,
                tags = listOf("mock", "tag", sortBy),
                stats = Stats(downloads = 100 - index, favorites = 10, rating = 5),
                uploadedAt = "2024-01-01T12:00:00+0000",
                urls = WallpaperUrls(
                    preview = representativeImageUrl.replace("_1920x1080.jpg", "_360x640.jpg"),
                    display = representativeImageUrl.replace("_1920x1080.jpg", "_1080x1920.jpg"),
                    full = representativeImageUrl.replace("_1920x1080.jpg", "_2160x3840.jpg")
                )
            )
        }

        val startIndex = offset
        val endIndex = (offset + limit).coerceAtMost(totalMockWallpapers.size)

        return if (startIndex >= totalMockWallpapers.size) {
            Result.success(emptyList())
        } else {
            val pageData = totalMockWallpapers.subList(startIndex, endIndex)
            Result.success(pageData)
        }
    }

    override suspend fun searchWallpapers(query: String, offset: Int, limit: Int): Result<List<Wallpaper>> {
        return getWallpapers(999, "search", offset, limit)
    }

    // CÁC HÀM FAVORITE

    override fun isFavorite(imageId: Int): Flow<Boolean> = favoriteDao.isFavorite(imageId)

    override fun getAllFavorites(): Flow<List<FavoriteEntity>> = favoriteDao.getAllFavorites()

    override suspend fun addFavorite(wallpaper: Wallpaper) {
        val entity = FavoriteEntity(
            imageId = wallpaper.id,
            previewUrl = wallpaper.urls.preview,
            addedAt = System.currentTimeMillis()
        )
        favoriteDao.addFavorite(entity)
    }

    override suspend fun removeFavorite(imageId: Int) {
        favoriteDao.removeFavorite(imageId)
    }
}