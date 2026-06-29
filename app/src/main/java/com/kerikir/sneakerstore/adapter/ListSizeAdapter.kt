package com.kerikir.sneakerstore.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kerikir.sneakerstore.databinding.ViewholderSizeBinding

class ListSizeAdapter(
    val items: MutableList<String>
) : RecyclerView.Adapter<ListSizeAdapter.ViewHolder>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1
    private lateinit var context: Context


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


    override fun getItemCount(): Int = items.size


    class ViewHolder(
        val binding: ViewholderSizeBinding
    ) : RecyclerView.ViewHolder(binding.root)
}