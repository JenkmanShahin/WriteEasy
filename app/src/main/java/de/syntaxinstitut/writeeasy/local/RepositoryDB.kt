package de.syntaxinstitut.writeeasy.local

import android.util.Log
import androidx.lifecycle.LiveData
import de.syntaxinstitut.writeeasy.data.model.Story
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryDB(private val database: StoryDatabase) {

    val storyList: LiveData<List<Story>> =
        database.storyDatabaseDao.getAll()

    suspend fun insert(story: Story) {
        try {
            database.storyDatabaseDao.insert(story)
        } catch (e: Exception) {
            Log.e("RepositoryDB", "Failed to insert into database: $e")
        }
    }

    suspend fun updateStory(story: Story) {
        withContext(Dispatchers.IO) {
            database.storyDatabaseDao.updateStory(story)
        }
    }
}