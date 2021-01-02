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
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

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
        val shoeIndex = ShoeDetailsFragmentArgs.fromBundle(requireArguments()).shoeIndex
        val shoe = mainViewModel.shoeList.value!![shoeIndex]

        shoeDetailsBinding.shoeNameEt.setText(shoe.name, TextView.BufferType.EDITABLE)
        shoeDetailsBinding.companyNameEt.setText(shoe.company, TextView.BufferType.EDITABLE)
        shoeDetailsBinding.shoeSizeEt.setText(shoe.size.toString(), TextView.BufferType.EDITABLE)
        shoeDetailsBinding.descriptionEt.setText(shoe.description, TextView.BufferType.EDITABLE)
        return shoeDetailsBinding.root
    }
}