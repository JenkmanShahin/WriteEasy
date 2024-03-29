package de.syntaxinstitut.writeeasy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class Story(
    @PrimaryKey(autoGenerate = true)
    @Json(name = "Ids")
    val ids: Int = 0,
    @Json(name = "Title")
    val title: String,
    @Json(name = "Stories")
    val stories: String,
    @Json(name = "Describtion")
    val description: String,
    @Json(name = "PersonName")
    val personName: String,
    @Json(name = "Photos")
    val photos: String,
    var read: Boolean = false,
    var saved: Boolean = false
)
