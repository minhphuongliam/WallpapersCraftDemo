package com.demo.wallpaperscraft.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.wallpaperscraft.data.local.entity.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao{
    // Thêm ảnh vào lịch sử
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrUpdateHistory(history : HistoryEntity)

    // Lấy toàn bộ lịch sử, sort theo thời gian mới nhất
    @Query("SELECT * FROM history ORDER BY setAt DESC")
    fun getHistory(): Flow<List<HistoryEntity>>

    // Xóa toàn bộ lịch sủ
    @Query("DELETE FROM history")
    suspend fun clearHistory()
}