package de.syntaxinstitut.writeeasy.data

import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.data.model.Story

class DataSource {
    fun loadStories(): List<Story>{
        return listOf(
            Story(
                1,
                "by Johny",
                "Me & my Sis",
                R.drawable.firststory,
                "Lorem ipsum dolor sit amet, consetetur sadised  invidunt ut labore"
            ),
            Story(
                2,
                "by Joudi",
                "Bestfriends",
                R.drawable.bestfriends,
                "Lorem ipsum dolor sit amet, consetetur sadised  invidunt ut labore"

            ),
            Story(
                3,
                 "by Sali",
                "Scribble",
                R.drawable.scribble_figure,
                "Lorem ipsum dolor sit amet, consetetur sadised  invidunt ut labore"
            ),
            Story(
                4,
                "by Tomy",
                "Hero",
                R.drawable.imgfriends,
                "Lorem ipsum dolor sit amet, consetetur sadised  invidunt ut labore"
            )
        )
    }
}