package de.syntaxinstitut.writeeasy.data.model

import com.squareup.moshi.Json

data class Story(
    @Json(name = "Ids")
    val ids: String,
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
    var read: Boolean = false
)
