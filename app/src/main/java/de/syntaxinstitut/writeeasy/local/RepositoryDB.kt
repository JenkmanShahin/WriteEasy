package de.syntaxinstitut.writeeasy.local

import de.syntaxinstitut.writeeasy.data.remote.StoryApi

class RepositoryDB(private val database: StoryDatabase, private val storyApi: StoryApi) {

//   val storyList: LiveData<List<Story>> = database.storyDatabaseDao.getAll()
//
//    private val _storyList = MutableLiveData<List<Story>> ()
//    val storylist: LiveData<List<Story>>
//        get() = _storyList
//
//    suspend fun insert(story: Story) {
//        try {
//            database.storyDatabaseDao.insert(story)
//            println("insertedStory")
//        } catch (e: Exception) {
//            Log.e("RepositoryDB", "Failed to insert into database: $e")
//        }
//    }
//    private val _readStories = MutableLiveData<MutableList<Story>>()
//    val readStories: LiveData<MutableList<Story>>
//        get() = _readStories
//
//    suspend fun getStories() {
//       withContext(Dispatchers.IO) {
//           val newStoryList = storyApi.retrofitService.getStories()
//       }
//    }

}