package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    private lateinit var welcomeFragmentBinding: FragmentWelcomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        welcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        welcomeFragmentBinding.instructionsButton.setOnClickListener(Navigation.createNavigateOnClickListener(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()))
        return welcomeFragmentBinding.root
    }
}