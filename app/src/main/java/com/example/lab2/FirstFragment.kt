package com.example.lab2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab2.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding


    val listener = object : OnItemClickListener {
        override fun onItemClick(food: Food) {
            // Реализация действия при клике на элемент
            val bundle = Bundle()
            bundle.putString("foodName", food.name)
            bundle.putString("image", food.image)
            bundle.putString("fullDescription", food.fullDescription)
            MAIN.navController.navigate(R.id.action_firstFragment_to_secondFragment, bundle)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodList = listOf(
            Food("Шашлик", "Дуже смачний шашлик", getString(R.string.kebab_description) ,  getString(R.string.kebab_image)),
            Food("Пельмені", "Дуже смачно, мало тіста", getString(R.string.dumpling_description) ,  getString(R.string.dumpling_image)),
            Food("Піцца", "Смачна піцца папероні", getString(R.string.pizza_description),  getString(R.string.pizza_image)),
        )
        val foodAdapter = FoodAdapter(foodList, listener)
        binding.rvFood.layoutManager = LinearLayoutManager(context)
        binding.rvFood.adapter = foodAdapter
    }
}

