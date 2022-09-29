package de.syntaxinstitut.writeeasy.ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.FragmentWritingBinding

class WritingNewFragment: Fragment(R.layout.fragment_writing) {

    private lateinit var binding: FragmentWritingBinding

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWritingBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        

//        binding.saStoryText.setOnClickListener{
//            val story = binding.storyText.text
//            val newStory = NewStory("Harry Poter", story, R.drawable.kid)
//
//        }

        var id = 12
       binding.saBtn.setOnClickListener{
           val story = binding.storyText.text.toString()
           val title = binding.textInputLayout.toString()
           val description = story.subSequence(0, 80).toString()
           viewModel.insertStory(Story(id.toString(), title, story, description, "Jan", R.drawable.bestfriends.toString()))
           id ++
       }
    }
}