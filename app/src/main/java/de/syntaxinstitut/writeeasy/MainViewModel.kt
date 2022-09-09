package de.syntaxinstitut.writeeasy

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import de.syntaxinstitut.writeeasy.data.DataSource
import de.syntaxinstitut.writeeasy.data.model.Story

const val TAG = "MAINVIEWMODEL"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private val dataSource = DataSource()

    private val _stories = MutableLiveData<List<Story>>()
    val stories: LiveData<List<Story>>
        get() = _stories

    init {
        _stories.value = dataSource.loadStories()
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
}