package com.kerikir.sneakerstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kerikir.sneakerstore.databinding.ViewholderAnotherItemBinding
import com.kerikir.sneakerstore.databinding.ViewholderBestSellerBinding
import com.kerikir.sneakerstore.databinding.ViewholderItemBinding
import com.kerikir.sneakerstore.model.ItemsModel

class ListItemsAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListItemsAdapter.ViewHolder {

        val binding = ViewholderBestSellerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ListItemsAdapter.ViewHolder, position: Int) {
        holder.biding.titleShoes.text = items[position].title
        holder.biding.priceShoes.text = items[position].price.toString() + " USD"
        holder.biding.ratingBar.rating = items[position].rating.toFloat()

        Glide.with(holder.itemView.context)
            .load(items[position].picUrl.first())
            .into(holder.biding.picShoes)

        Glide.with(holder.itemView.context)
            .load(items[position].logo)
            .into(holder.biding.picBrand)
    }


    override fun getItemCount(): Int = items.size


    companion object {
        const val TYPE_ITEM = 0
        const val TYPE_ANOTHER_ITEM = 1
    }



    class ViewHolderItem(val biding: ViewholderItemBinding)
        : RecyclerView.ViewHolder(biding.root)

    class ViewHolderAnotherItem(val biding: ViewholderAnotherItemBinding)
        : RecyclerView.ViewHolder(biding.root)
}