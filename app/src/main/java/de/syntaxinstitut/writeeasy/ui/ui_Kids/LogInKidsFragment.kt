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
import de.syntaxinstitut.writeeasy.databinding.FragmentLoginkidsBinding

class LogInKidsFragment: Fragment(R.layout.fragment_loginkids) {

    private lateinit var binding: FragmentLoginkidsBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_loginkids, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.LogInButtonkids.setOnClickListener{
            val email = binding.Email.text.toString()
            val password = binding.Password.text.toString()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()){
                viewModel.login(email, password)
            }
        }


    }
}