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
import de.syntaxinstitut.writeeasy.databinding.FragmentStartBinding


class StartFragment: Fragment() {


    private lateinit var binding: FragmentStartBinding


    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = de.syntaxinstitut.writeeasy.databinding.FragmentStartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.LogInButton.setOnClickListener{
            val email = binding.EmailText.text.toString()
            val password = binding.PassText.text.toString()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()){
                viewModel.login(email, password)
            }
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.homeKidsFragment)
                }
            }
        )


            binding.registerButton.setOnClickListener{
                val email = binding.EmailText.text.toString()
                val password = binding.PassText.text.toString()

                if (!email.isNullOrEmpty() && !password.isNullOrEmpty()){
                    viewModel.register(email, password)
                }
            }



        binding.registerButton.setOnClickListener{
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToHomeKidsFragment())
        }

        binding.LogInButton.setOnClickListener{
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToHomeKidsFragment())
        }
    }
}