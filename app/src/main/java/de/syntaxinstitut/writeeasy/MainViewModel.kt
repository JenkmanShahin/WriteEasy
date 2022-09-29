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
import de.syntaxinstitut.writeeasy.local.RepositoryDB
import de.syntaxinstitut.writeeasy.local.getDatabase
import kotlinx.coroutines.launch

const val TAG = "MAINVIEWMODEL"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val repository = Repository(StoryApi)
    private val database = getDatabase(application)
    private val repositoryDB = RepositoryDB(database)

   /* private val _readStories = MutableLiveData<List<ReadStories>>()
    val readStories: LiveData<List<ReadStories>>
    get() = _readStories

    private val _stories = MutableLiveData<List<Story>>()
    val stories: LiveData<List<Story>>
        get() = _stories

    private val _myStories = MutableLiveData<List<MyStories>>()
    val myStories: LiveData<List<MyStories>>
    get() = _myStories

    private val _story = MutableLiveData<List<ReadStories>>()
    val story: LiveData<List<ReadStories>>
    get() = _story*/

    val stories: LiveData<List<Story>> = repository.storylist
    var readStories: LiveData<List<Story>> = MutableLiveData()
    val storyList = repositoryDB.storyList
    var savedStories: LiveData<List<Story>> = MutableLiveData()

    fun insertStory(story: Story) {
        viewModelScope.launch {
            repositoryDB.insert(story)
        }
    }

//    val inputText = MutableLiveData<String>()


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
            repository.getStories()
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

    fun adtoFavs(story: Story) {
        viewModelScope.launch {
            repositoryDB.updateStory(story)
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