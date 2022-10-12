package de.syntaxinstitut.writeeasy.ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.adapter.SavedStoriesAdapter
import de.syntaxinstitut.writeeasy.databinding.FragmentSavedBinding


class SavedFragment: Fragment(R.layout.saved_list) {

    private lateinit var binding: FragmentSavedBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val savedStories = SavedStoriesAdapter()
        binding.SavedRecyclerView.adapter = savedStories


        viewModel.savedStories.observe(
            viewLifecycleOwner,
            Observer {
                savedStories.submitList(it)
            }
        )
        binding.ButtonHome.setOnClickListener{
            findNavController().navigate(SavedFragmentDirections.actionSavedKidsFragmentToHomeKidsFragment())
        }

        binding.ButtonProfile.setOnClickListener{
            findNavController().navigate(SavedFragmentDirections.actionSavedKidsFragmentToProfileKidsFragment())
        }

    }
}