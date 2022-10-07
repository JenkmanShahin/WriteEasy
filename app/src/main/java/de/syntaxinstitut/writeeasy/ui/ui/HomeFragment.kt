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

        val storiesAdapter = AllStoriesAdapter(emptyList())
        binding.allStoriesRecyclerView.adapter = storiesAdapter

        viewModel.stories.observe(
            viewLifecycleOwner,
            Observer {
               storiesAdapter.submitList(it)
            }
        )

        val readStories = ReadStoriesAdapter()
        binding.alreadyReadRecyclerView.adapter = readStories

//       var filter: List<Story>? = viewModel.storyList.value
//        viewModel.readStories = MutableLiveData(filter?.filter { it.read == true })
//          Log.d("Read:", viewModel.readStories.value?.size.toString())
//
//
//        viewModel.readStories.observe(
//            viewLifecycleOwner,
//            Observer {
//                readStories.submitList(it)
//            }
//        )

//        viewModel.stories.observe(
//            viewLifecycleOwner,
//            Observer {
//              readStories.submitList(it)
//                binding.alreadyReadRecyclerView.adapter = ReadStoriesAdapter()
//            }
//        )

        binding.savedButtonP.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeKidsFragmentToSavedKidsFragment())
        }

        binding.ProfileButton.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeKidsFragmentToProfileKidsFragment())
        }

    }

}