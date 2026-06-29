package com.kerikir.sneakerstore.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kerikir.sneakerstore.databinding.ViewholderColorShoesBinding

class ListColorsAdapter(
    val items: MutableList<String>,
    var picMain: ImageView
) : RecyclerView.Adapter<ListColorsAdapter.ViewHolder>() {

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
        val binding: ViewholderColorShoesBinding
    ) : RecyclerView.ViewHolder(binding.root)
}