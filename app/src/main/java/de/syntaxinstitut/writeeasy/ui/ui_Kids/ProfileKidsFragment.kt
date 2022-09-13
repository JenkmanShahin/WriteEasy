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
import de.syntaxinstitut.writeeasy.adapter.MyStoriesAdapter
import de.syntaxinstitut.writeeasy.databinding.FragmentProfilrkidsBinding

class ProfileKidsFragment: Fragment(R.layout.fragment_profilrkids) {

    private lateinit var  binding: FragmentProfilrkidsBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilrkidsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.myStories.observe(
            viewLifecycleOwner,
            Observer {
                binding.MyStoriesRecyclerView.adapter = MyStoriesAdapter(it)
            }
        )
        binding.savedButtonP.setOnClickListener{
            findNavController().navigate(HomeKidsFragmentDirections.actionHomeKidsFragmentToSavedKidsFragment())
        }

        binding.homeButtonP.setOnClickListener{
            findNavController().navigate(ProfileKidsFragmentDirections.actionProfileKidsFragmentToHomeKidsFragment())
        }
    }
}