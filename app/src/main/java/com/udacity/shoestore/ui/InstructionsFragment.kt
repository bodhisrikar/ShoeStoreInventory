package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {
    private lateinit var instructionsFragmentBinding: FragmentInstructionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        instructionsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        instructionsFragmentBinding.proceedToShoeStoreInventoryButton.setOnClickListener(Navigation.createNavigateOnClickListener(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()))
        return instructionsFragmentBinding.root
    }

    companion object {

    }
}