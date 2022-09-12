package de.syntaxinstitut.writeeasy.data

import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.data.model.ReadStories

class ReadDataSource {
    fun loadReadStories(): List<ReadStories> {

        return listOf(
            ReadStories(
                1,
                "",
                "by Joudi",
                R.drawable.drawings

                ),
            ReadStories(
                2,
                "",
                "by Saly",
                R.drawable.kid

            ),
            ReadStories(
                3,
                "",
                "by Tomy",
                R.drawable.bestfriends

            ),
            ReadStories(
                4,
                "",
                "by Chris",
                R.drawable.profilepic
            )
        )
    }
}

