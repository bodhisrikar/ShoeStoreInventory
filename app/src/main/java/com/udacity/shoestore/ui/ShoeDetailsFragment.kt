package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailsFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var shoeDetailsBinding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        shoeDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        shoeDetailsBinding.apply {
            saveBtn.setOnClickListener {
                if (!shoeNameEt.text.isNullOrBlank() && !shoeSizeEt.text.isNullOrBlank() &&
                    !companyNameEt.text.isNullOrBlank() && !descriptionEt.text.isNullOrBlank()) {
                    mainViewModel.shoeList.value?.add(
                        Shoe(
                            shoeNameEt.text.toString(),
                            shoeSizeEt.text.toString().toDouble(),
                            companyNameEt.text.toString(),
                            descriptionEt.text.toString(),
                            mutableListOf("", "")
                        )
                    )
                    findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
                } else {
                    Snackbar.make(this.root, "Please fill in all the fields", Snackbar.LENGTH_SHORT).show()
                }
            }

            cancelBtn.setOnClickListener {
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            }
        }
        return shoeDetailsBinding.root
    }
}