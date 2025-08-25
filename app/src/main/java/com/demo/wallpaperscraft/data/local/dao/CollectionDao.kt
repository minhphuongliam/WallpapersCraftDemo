package com.demo.wallpaperscraft.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.demo.wallpaperscraft.data.local.entity.CollectionEntity
import com.demo.wallpaperscraft.data.local.entity.ImageCollectionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CollectionDao {
    // Thao tác với CollectionEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collection: CollectionEntity)

    @Query("SELECT * FROM collections")
    fun getAllCollections(): Flow<List<CollectionEntity>>

    //Thao tác với ImageCollection
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertImageIntoCollection(image: ImageCollectionEntity)

    @Update
    suspend fun updateImageInCollection(image: ImageCollectionEntity)

    @Query("UPDATE image_collection SET isInCurrentSet = :inSet WHERE collectionId = :collectionId")
    suspend fun updateIsInCurrentSetForCollection(collectionId: String, inSet: Boolean)

    @Query("DELETE FROM image_collection WHERE collectionId = :collectionId AND isInCurrentSet = 0")
    suspend fun deleteInactiveImagesFromCollection(collectionId: String)

    @Query("SELECT * FROM image_collection WHERE collectionId = :collectionId AND isInCurrentSet = 1 AND localPath IS NOT NULL ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomImageFromCollection(collectionId: String): ImageCollectionEntity?

}