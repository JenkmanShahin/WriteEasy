package de.syntaxinstitut.writeeasy.ui.ui_Kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.data.model.NewStory
import de.syntaxinstitut.writeeasy.databinding.FragmentWritingkidsBinding

class WritingNewKidsFragment: Fragment(R.layout.fragment_writingkids) {

    private lateinit var binding: FragmentWritingkidsBinding

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWritingkidsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        

        /*binding.saStoryText.setOnClickListener{
            val story = binding.storyText.text
            val newStory = NewStory("Harry Poter", story, R.drawable.kid)

        }*/

        binding.saBtn.setOnClickListener{
            val story = binding.storyText.text
            val newStory = NewStory("Harry Poter", story, R.drawable.kid)

        }
    }
}