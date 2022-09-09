package de.syntaxinstitut.writeeasy.ui.ui_Kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.adapter.AllStoriesAdapter
import de.syntaxinstitut.writeeasy.databinding.FragmentHomekidsBinding

class HomeKidsFragment: Fragment(R.layout.fragment_homekids) {

    private lateinit var binding: FragmentHomekidsBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomekidsBinding.inflate(inflater, container, false)

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
                binding.alreadyReadRecyclerView.adapter = AllStoriesAdapter(it)
            }
        )

    }

}