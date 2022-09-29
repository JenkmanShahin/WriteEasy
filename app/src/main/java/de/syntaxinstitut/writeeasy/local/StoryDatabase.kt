package de.syntaxinstitut.writeeasy.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.writeeasy.data.model.Story


@Database(entities = [Story::class], version = 1)
abstract class StoryDatabase :  RoomDatabase() {

    abstract val storyDatabaseDao: StoryDatabaseDao
}

private lateinit var INSTANCE: StoryDatabase

fun getDatabase(context: Context): StoryDatabase {
    synchronized(StoryDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                StoryDatabase::class.java,
                "story_database"
            ).build()
        }
    }
    return INSTANCE
}