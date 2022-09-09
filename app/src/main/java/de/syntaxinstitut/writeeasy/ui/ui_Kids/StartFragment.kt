package de.syntaxinstitut.writeeasy.ui.ui_Kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.databinding.FragmentStartBinding

class StartFragment: Fragment() {


    private lateinit var binding: FragmentStartBinding


    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.registerButtonStart.setOnClickListener{
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToRegisterKidsFragment2())
        }

        binding.LohInButtonStart.setOnClickListener{
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToLogInKidsFragment2())
        }
    }
}