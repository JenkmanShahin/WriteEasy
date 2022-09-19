package de.syntaxinstitut.writeeasy.ui.ui_Kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.databinding.FragmentStorydetailsBinding

class StoryDetailsFragment: Fragment(R.layout.fragment_storydetails) {

    private lateinit var binding: FragmentStorydetailsBinding

    private val viewModel: MainViewModel by activityViewModels()

    private var storyId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            storyId = it.getLong("storyId")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStorydetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val story = viewModel.story.value?.find { it.id == storyId }

        if (story != null) {
            binding.CoverFrame.setImageResource(story.image)
            binding.storyText.text = getString(R.string.placeholder)
        }

        binding.StoryFrame.setOnClickListener{
            findNavController().navigateUp()
        }
    }
}