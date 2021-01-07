package com.udacity.shoestore.ui

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailsFragment : Fragment() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var shoeDetailsBinding: FragmentShoeDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        shoeDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        shoeDetailsBinding.apply {
            saveBtn.setOnClickListener {
                mainViewModel.shoeList.value?.add(Shoe(shoeNameEt.text.toString(), shoeSizeEt.text.toString().toDouble(), companyNameEt.text.toString(), descriptionEt.text.toString(), mutableListOf("")))
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            }
        }
        return shoeDetailsBinding.root
    }
}