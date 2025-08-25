package com.demo.wallpaperscraft.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.wallpaperscraft.data.local.dao.CollectionDao
import com.demo.wallpaperscraft.data.local.dao.FavoriteDao
import com.demo.wallpaperscraft.data.local.dao.HistoryDao
import com.demo.wallpaperscraft.data.local.entity.CollectionEntity
import com.demo.wallpaperscraft.data.local.entity.FavoriteEntity
import com.demo.wallpaperscraft.data.local.entity.HistoryEntity
import com.demo.wallpaperscraft.data.local.entity.ImageCollectionEntity

// Lớp định nghĩa database
// Thông báo cho Room các Entities - bảng  và cung cấp abstr method DAO
@Database(
    entities = [
        FavoriteEntity::class,
        HistoryEntity::class,
        CollectionEntity::class,
        ImageCollectionEntity::class
    ],
    version = 1,
    exportSchema = false // Tắt export schema để đơn giản hóa
)
abstract class AppDatabase : RoomDatabase(){
    // Các method để truy cập Dao
    abstract fun favoriteDao(): FavoriteDao
    abstract fun historyDao(): HistoryDao
    abstract fun collectionDao(): CollectionDao
}