package com.kerikir.sneakerstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
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
        TODO("Not yet implemented")
    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    class ViewHolder(
        val binding: ViewholderColorShoesBinding
    ) : RecyclerView.ViewHolder(binding.root)
}