package de.syntaxinstitut.writeeasy.ui.ui_Kids

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.databinding.FragmentRegisterkidsBinding

class RegisterKidsFragment: Fragment(R.layout.fragment_registerkids) {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentRegisterkidsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registerkids, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.RegisterButton.setOnClickListener{
            val email = binding.EmailText.text.toString()
            val password = binding.PasswordText.text.toString()
            viewModel.register(email, password)
        }

    }
}