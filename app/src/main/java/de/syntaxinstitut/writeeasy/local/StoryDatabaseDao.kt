package de.syntaxinstitut.writeeasy.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntaxinstitut.writeeasy.data.model.Story


@Dao
interface StoryDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(story: Story)

    @Insert
    suspend fun insertAll(story: List<Story>)

    @Update
    suspend fun update(story: Story)

    @Query("SELECT * FROM Story")
    fun getAll(): LiveData<List<Story>>
}