package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodAdapter(private val food: List<Food>, private var listener: OnItemClickListener) : RecyclerView.Adapter<FoodAdapter.FoodAdapterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)

        return FoodAdapterHolder(view, listener)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onBindViewHolder(holder: FoodAdapterHolder, position: Int) {
        val foodItem = food[position]
        holder.bind(foodItem)
        Glide.with(holder.itemView.context).load(foodItem.image).into(holder.imageView)
    }
    override fun getItemCount() = food.size
    inner class FoodAdapterHolder(itemView: View, private val listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.foodName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.foodDescription)
        val imageView: ImageView = itemView.findViewById(R.id.foodImage)

        fun bind(foodItem: Food) {
            nameTextView.text = foodItem.name
            descriptionTextView.text = foodItem.shortDescription

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(foodItem)
                }
            }
        }
    }
}
