package de.syntaxinstitut.writeeasy.data.model

import android.text.Editable

data class NewStory(
    val title: String,
    val story: Editable,
    val image: Int
)