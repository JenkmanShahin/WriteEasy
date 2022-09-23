package de.syntaxinstitut.writeeasy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.data.remote.StoryApi

class Repository(private val storyApi: StoryApi) {

    private val _storyList = MutableLiveData<List<Story>> ()
    val storylist: LiveData<List<Story>>
        get() = _storyList

    suspend fun getStories() {
        _storyList.value = storyApi.retrofitService.getStories()
    }
}