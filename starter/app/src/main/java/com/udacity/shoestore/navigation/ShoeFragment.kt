package com.udacity.shoestore.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

/**
 * A fragment representing a list of Items.
 */
class ShoeFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentShoeDetailBinding.inflate(
            inflater
        )
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.saveButton.setOnClickListener {
            viewModel.addShoe(
                binding.shoeName.text.toString(),
                binding.shoeSize.text.toString().toDouble(),
                binding.company.text.toString(),
                binding.description.text.toString()
            )
            it.findNavController().navigate(ShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
        }
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(ShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
        }
        return binding.root
    }

}