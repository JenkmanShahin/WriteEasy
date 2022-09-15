package de.syntaxinstitut.writeeasy.ui.ui_Kids

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.writeeasy.MainViewModel
import de.syntaxinstitut.writeeasy.R
import de.syntaxinstitut.writeeasy.databinding.FragmentPlaykidsBinding

class PlayKidsFragment: Fragment(R.layout.fragment_playkids) {

    private lateinit var binding: FragmentPlaykidsBinding
    private val viewModel: MainViewModel by activityViewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }
}