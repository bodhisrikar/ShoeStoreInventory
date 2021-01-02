package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
    private lateinit var shoeListBinding: FragmentShoeListBinding
    private val activityViewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        shoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        activityViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            for ((index,shoe) in shoes.withIndex()) {
                addShoeText(index, shoe)
            }
        })
        return shoeListBinding.root
    }

    private fun addShoeText(index: Int, shoe: Shoe) {
        val textView = TextView(requireActivity())
        textView.text = shoe.name
        textView.setPadding(16, 16, 16, 16)
        textView.gravity = Gravity.CENTER_VERTICAL
        shoeListBinding.shoeLl.addView(textView)

        textView.setOnClickListener(Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment(index)))
    }
}