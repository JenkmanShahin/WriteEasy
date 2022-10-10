package de.syntaxinstitut.writeeasy.ui.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.databinding.FragmentStorydetailsBinding

class StoryDetailsFragment: Fragment(R.layout.fragment_storydetails) {

    private lateinit var binding: FragmentStorydetailsBinding

    private val viewModel: MainViewModel by activityViewModels()

    private var storyId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            storyId = it.getInt("storyid")
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
        val story = viewModel.stories.value?.find { it.ids == storyId }



            story?.read = true
        if (story != null) {
            viewModel.updateStory(story)
        }




        binding.SaveButton.setOnClickListener{
            story?.saved = true
            if (story != null) {
                viewModel.updateStory(story)
            }
        }


        val imgUri = story?.photos?.toUri()?.buildUpon()?.scheme("https")?.build()

        binding.CoverFrame.load(imgUri)

     binding.cancelButton.setOnClickListener{
            findNavController().navigate(StoryDetailsFragmentDirections.actionStoryShowKidsFragmentToHomeKidsFragment())
       }
        binding.TitleText.text = story?.title
        binding.storyText.text = story?.stories
        binding.storyText.movementMethod = ScrollingMovementMethod()
    }
}