package com.udacity.shoestore.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        viewModel.shoes.observe(viewLifecycleOwner, {
            it.forEach { shoe ->
                val shoeView = inflater.inflate(R.layout.fragment_shoe_item, null, false)
                shoeView.findViewById<TextView>(R.id.shoe_name_textView).text = shoe.name
                binding.list.addView(shoeView)
            }
        })
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeFragment)
        }
        return binding.root
    }
}