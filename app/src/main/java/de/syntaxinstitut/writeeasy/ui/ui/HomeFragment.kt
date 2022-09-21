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
import de.syntaxinstitut.writeeasy.adapter.AllStoriesAdapter
import de.syntaxinstitut.writeeasy.adapter.ReadStoriesAdapter
import de.syntaxinstitut.writeeasy.databinding.FragmentHomeBinding


class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stories.observe(
            viewLifecycleOwner,
            Observer {
                binding.allStoriesRecyclerView.adapter = AllStoriesAdapter(it)
            }
        )

        viewModel.readStories.observe(
            viewLifecycleOwner,
            Observer {
                binding.alreadyReadRecyclerView.adapter = ReadStoriesAdapter(it)
            }
        )

        binding.savedButtonP.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeKidsFragmentToSavedKidsFragment())
        }

        binding.ProfileButton.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeKidsFragmentToProfileKidsFragment())
        }

    }

}