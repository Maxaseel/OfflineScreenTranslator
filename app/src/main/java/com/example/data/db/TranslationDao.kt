package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.TranslationRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface TranslationDao {
    @Query("SELECT * FROM translation_records ORDER BY timestamp DESC")
    fun getAllHistory(): Flow<List<TranslationRecord>>

    @Query("SELECT * FROM translation_records WHERE isFavorite = 1 ORDER BY timestamp DESC")
    fun getFavorites(): Flow<List<TranslationRecord>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: TranslationRecord): Long

    @Query("UPDATE translation_records SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavorite(id: Long, isFavorite: Boolean)

    @Query("DELETE FROM translation_records WHERE id = :id")
    suspend fun deleteRecord(id: Long)

    @Query("DELETE FROM translation_records WHERE isFavorite = 0")
    suspend fun clearNonFavoriteHistory()

    @Query("DELETE FROM translation_records")
    suspend fun clearAll()
}
