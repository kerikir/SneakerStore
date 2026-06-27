package com.kerikir.sneakerstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kerikir.sneakerstore.databinding.ViewholderBestSellerBinding
import com.kerikir.sneakerstore.model.ItemsModel

class BestSellerAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<BestSellerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerAdapter.ViewHolder {

        val binding = ViewholderBestSellerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: BestSellerAdapter.ViewHolder, position: Int) {
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



    class ViewHolder(val biding: ViewholderBestSellerBinding)
        : RecyclerView.ViewHolder(biding.root)
}