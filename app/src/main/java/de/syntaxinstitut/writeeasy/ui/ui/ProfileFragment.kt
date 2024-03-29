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
import de.syntaxinstitut.writeeasy.databinding.FragmentProfileBinding

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private lateinit var  binding: FragmentProfileBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonLogout.setOnClickListener{
            viewModel.logout()
            if (viewModel.currentUser != null) {
                findNavController().navigate(R.id.startFragment)
            }
        }

        binding.savedButtonP.setOnClickListener{
            findNavController().navigate(ProfileFragmentDirections.actionProfileKidsFragmentToSavedKidsFragment())
        }

        binding.homeButtonP.setOnClickListener{
            findNavController().navigate(ProfileFragmentDirections.actionProfileKidsFragmentToHomeKidsFragment())
        }
        binding.WriteButton.setOnClickListener{
            findNavController().navigate(ProfileFragmentDirections.actionProfileKidsFragmentToWritingNewKidsFragment())
        }
        binding.SaveButton.setOnClickListener{
            findNavController().navigate(ProfileFragmentDirections.actionProfileKidsFragmentToSavedKidsFragment())
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) {
                    findNavController().navigate(R.id.startFragment)
                }
            }
        )
    }
}

