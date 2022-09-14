package de.syntaxinstitut.writeeasy.ui.ui_Kids

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.databinding.FragmentWritingkidsBinding

class WritingNewKidsFragment: Fragment() {

    private lateinit var binding: FragmentWritingkidsBinding

    private val viewModel: MainViewModel by activityViewModels()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    fun saBtn(view: View){

        val storytext: EditText = findViewById(R.id.story_text)
        val getstorytext:TextView = findViewById(R.id.textDisplay)

        var str:String = storytext.toString()

        getstorytext.setText(str)
    }

    private fun findViewById(storyText: Int): EditText {
        return binding.storyText
    }


}