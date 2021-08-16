package com.udacity.shoestore.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

/**
 * A fragment representing a list of Items.
 */
class ShoeFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.saveButton.setOnClickListener {
            viewModel.addShoe()
            it.findNavController()
                .navigate(ShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
        }
        binding.cancelButton.setOnClickListener {
            it.findNavController()
                .navigate(ShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
        }

        return binding.root
    }

}