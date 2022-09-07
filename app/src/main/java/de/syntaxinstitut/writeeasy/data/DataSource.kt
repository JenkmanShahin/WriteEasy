package de.syntaxinstitut.writeeasy.data

import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.data.model.Story

class DataSource {
    fun loadStories(): List<Story>{
        return listOf(
            Story(
                "wald",
                "",
                R.drawable.login_pic
            )
        )
    }
}