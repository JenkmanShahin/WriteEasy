package de.syntaxinstitut.writeeasy.data

import de.syntaxinstitut.writeeasy.R

class MyStoriesDatasource {
    fun loadMyStories(): List<MyStories> {

            return listOf(
                MyStories(
                    1,
                    "",
                    R.drawable.car
                ),
                MyStories(
                    2,
                    "",
                    R.drawable.happy_human
                ),
                MyStories(
                    3,
                    "",
                    R.drawable.drawings
                ),
                MyStories(
                    4,
                    "",
                    R.drawable.family_with_house
                )
            )
        }
}