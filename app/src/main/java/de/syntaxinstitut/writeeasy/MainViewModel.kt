package de.syntaxinstitut.writeeasy

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import de.syntaxinstitut.writeeasy.data.Repository
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.data.remote.StoryApi
import de.syntaxinstitut.writeeasy.local.getDatabase
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

enum class ApiStatus { LOADING, ERROR, DONE }

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val database = getDatabase(application)
    private val repository = Repository(StoryApi, database)


    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
    get() = _loading

    val stories = repository.storyList

    var readStories = repository.readStoryList

    var savedStories = repository.savedStoryList


    fun insertStory(story: Story) {
        viewModelScope.launch {
            repository.insert(story)
        }
    }

    fun updateStory(story: Story) {
        viewModelScope.launch {
            repository.update(story)
        }
    }


//    init {
//        _stories.value = dataSource.loadStories()
//
//        _myStories.value = myStoriesDatasource.loadMyStories()
//
//        _readStories.value = readDataSource.loadReadStories()
//    }

 //   init {
 //       _story.value = readDataSource.loadReadStories()
  //  }

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try {
                repository.getStories()
                _loading.value = ApiStatus.DONE
            } catch (e:Exception) {
                Log.e(TAG, "Error loading Data $e")
                if (stories.value.isNullOrEmpty()) {
                    _loading.value = ApiStatus.ERROR
                } else {
                    _loading.value = ApiStatus.DONE
                }
            }
        }
    }


    private val _currentUser = MutableLiveData<FirebaseUser>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser>
    get() = _currentUser


    fun login(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
            if (it.isSuccessful) {
                _currentUser.value = firebaseAuth.currentUser
            } else{
                Log.e(TAG, "Log In failed: ${it.exception}")
            }
        }
    }


    fun register( email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
            if (it.isSuccessful) {
                register(email, password)
            } else {
                Log.e(TAG, "Registering failed: ${it.exception}")
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }
}