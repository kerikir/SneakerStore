package com.kerikir.sneakerstore.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kerikir.sneakerstore.R
import com.kerikir.sneakerstore.databinding.ViewholderCategoryBinding
import com.kerikir.sneakerstore.model.CategoryModel

class CategoryAdapter(
    val items: MutableList<CategoryModel>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ViewholderCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = items[position]

        holder.binding.titleCategory.text = item.title
        Glide.with(holder.itemView.context)
            .load(item.picUrl)
            .into(holder.binding.picCategory)

        if (selectedPosition == position) {
            holder.binding.picCategory.setBackgroundResource(R.drawable.green_bg)
            ImageViewCompat.setImageTintList(
                holder.binding.picCategory,
                ColorStateList.valueOf(
                    ContextCompat.getColor(holder.itemView.context, R.color.white)
                )
            )

        } else {
            holder.binding.picCategory.setBackgroundResource(R.drawable.gray_oval_bg)
            ImageViewCompat.setImageTintList(
                holder.binding.picCategory,
                ColorStateList.valueOf(
                    ContextCompat.getColor(holder.itemView.context, R.color.black)
                )
            )
        }
    }


    override fun getItemCount(): Int = items.size



    inner class ViewHolder(
        val binding: ViewholderCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root)
}