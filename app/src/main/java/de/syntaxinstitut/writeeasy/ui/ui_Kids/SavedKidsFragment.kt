package de.syntaxinstitut.writeeasy.ui.ui_Kids

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


class SavedKidsFragment: Fragment(R.layout.saved_list) {

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

        viewModel.stories.observe(
            viewLifecycleOwner,
            Observer {
                binding.SavedRecyclerView.adapter = SavedStoriesAdapter(it)
            }
        )

        binding.ButtonHome.setOnClickListener{
            findNavController().navigate(SavedKidsFragmentDirections.actionSavedKidsFragmentToHomeKidsFragment())
        }

        binding.ButtonProfile.setOnClickListener{
            findNavController().navigate(SavedKidsFragmentDirections.actionSavedKidsFragmentToProfileKidsFragment())
        }

    }
}