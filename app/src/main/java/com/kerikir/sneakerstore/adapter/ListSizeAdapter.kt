package com.kerikir.sneakerstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kerikir.sneakerstore.R
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
        context = parent.context
        val binding = ViewholderSizeBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.binding.size.text = items[position]

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position

            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

        if (selectedPosition == position) {
            holder.binding.sizeLayout.setBackgroundResource(R.drawable.green_size_bg)
            holder.binding.size.setTextColor(context.resources.getColor(R.color.white))
        } else {
            holder.binding.sizeLayout.setBackgroundResource(R.drawable.gray_bg)
            holder.binding.size.setTextColor(context.resources.getColor(R.color.black))
        }
    }


    override fun getItemCount(): Int = items.size


    class ViewHolder(
        val binding: ViewholderSizeBinding
    ) : RecyclerView.ViewHolder(binding.root)
}