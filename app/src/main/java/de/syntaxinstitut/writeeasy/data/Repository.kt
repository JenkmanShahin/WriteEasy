package de.syntaxinstitut.writeeasy.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.data.remote.StoryApi
import de.syntaxinstitut.writeeasy.local.StoryDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val api: StoryApi, private val database: StoryDatabase) {

    val storyList: LiveData<List<Story>> = database.storyDatabaseDao.getAll()

//    private val _storyList = MutableLiveData<List<Story>> ()
//    val storylist: LiveData<List<Story>>
//        get() = _storyList

    suspend fun insert(story: Story) {
        try {
            database.storyDatabaseDao.insert(story)
            println("insertedStory")
        } catch (e: Exception) {
            Log.e("RepositoryDB", "Failed to insert into database: $e")
        }
    }

    private val _readStories = MutableLiveData<MutableList<Story>>()
    val readStories: LiveData<MutableList<Story>>
    get() = _readStories



    suspend fun getStories() {
        withContext(Dispatchers.IO) {
            val newStoryList = api.retrofitService.getStoryList()
            database.storyDatabaseDao.insertAll(newStoryList)
        }
    }
}