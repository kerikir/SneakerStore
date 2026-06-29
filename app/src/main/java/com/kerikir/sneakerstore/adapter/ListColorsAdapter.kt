package com.kerikir.sneakerstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kerikir.sneakerstore.databinding.ViewholderColorShoesBinding

class ListColorsAdapter(
    val items: MutableList<String>,
    var picMain: ImageView
) : RecyclerView.Adapter<ListColorsAdapter.ViewHolder>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    private lateinit var context: Context


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        context = parent.context
        val binding = ViewholderColorShoesBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        Glide.with(context)
            .load(items[position])
            .into(holder.binding.picture)

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position

            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            Glide.with(context)
                .load(items[position])
                .into(picMain)
        }
    }


    override fun getItemCount(): Int = items.size


    class ViewHolder(
        val binding: ViewholderColorShoesBinding
    ) : RecyclerView.ViewHolder(binding.root)
}