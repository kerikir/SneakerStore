package com.kerikir.sneakerstore.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kerikir.sneakerstore.databinding.ActivityCartBinding
import com.kerikir.sneakerstore.model.ItemsModel

class CartAdapter(
    private val listItemSelected: ArrayList<ItemsModel>
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(
        val binding: ActivityCartBinding
    ) : RecyclerView.ViewHolder(binding.root)
}