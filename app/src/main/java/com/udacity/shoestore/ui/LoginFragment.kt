package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var loginFragmentBinding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        loginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        loginFragmentBinding.loginButton.setOnClickListener(Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))
        loginFragmentBinding.createAccountButton.setOnClickListener(Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()))
        return loginFragmentBinding.root
    }

    companion object {

    }
}