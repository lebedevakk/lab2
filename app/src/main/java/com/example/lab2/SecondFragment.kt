package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.bumptech.glide.Glide
import com.example.lab2.databinding.FragmentFirstBinding
import com.example.lab2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            val foodName = bundle.getString("foodName", "")
            val imageUrlFood = bundle.getString("image", "")
            val fullDescription = bundle.getString("fullDescription", "")

            binding.foodName.text = foodName
            binding.foodFullDescription.text = fullDescription
            Glide.with(this).load(imageUrlFood).into(binding.foodImage)

            val callback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    handleBackPress()
                }
            }
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        }
    }
    private fun handleBackPress() {
        MAIN.navController.navigate(R.id.action_secondFragment_to_firstFragment)
    }
}