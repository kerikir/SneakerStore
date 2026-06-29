package com.kerikir.sneakerstore.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kerikir.sneakerstore.activity.DetailActivity
import com.kerikir.sneakerstore.databinding.ViewholderAnotherItemBinding
import com.kerikir.sneakerstore.databinding.ViewholderBestSellerBinding
import com.kerikir.sneakerstore.databinding.ViewholderItemBinding
import com.kerikir.sneakerstore.model.ItemsModel

class ListItemsAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {

        context = parent.context
        return when (viewType) {

            TYPE_ITEM -> {
                val binding = ViewholderItemBinding.inflate(
                    LayoutInflater.from(context), parent, false
                )
                ViewHolderItem(binding)
            }

            TYPE_ANOTHER_ITEM -> {
                val binding = ViewholderAnotherItemBinding.inflate(
                    LayoutInflater.from(context), parent, false
                )
                ViewHolderAnotherItem(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        fun bindCommonData(
            title: String, price: String, rating: Float, picUrl: String, logo: String
        ) {
            when (holder) {

                is ViewHolderItem -> {
                    holder.biding.titleShoes.text = title
                    holder.biding.priceShoes.text = price
                    holder.biding.ratingBar.rating = rating

                    Glide.with(holder.itemView.context)
                        .load(picUrl)
                        .into(holder.biding.picShoes)

                    Glide.with(holder.itemView.context)
                        .load(logo)
                        .into(holder.biding.picBrand)

                    holder.itemView.setOnClickListener {
                        val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                        intent.putExtra("object", items[position])
                        holder.itemView.context.startActivity(intent)
                    }
                }

                is ViewHolderAnotherItem -> {
                    holder.biding.titleShoes.text = title
                    holder.biding.priceShoes.text = price
                    holder.biding.ratingBar.rating = rating

                    Glide.with(holder.itemView.context)
                        .load(picUrl)
                        .into(holder.biding.picShoes)

                    Glide.with(holder.itemView.context)
                        .load(logo)
                        .into(holder.biding.picBrand)

                    holder.itemView.setOnClickListener {
                        val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                        intent.putExtra("object", items[position])
                        holder.itemView.context.startActivity(intent)
                    }
                }
            }
        }

        bindCommonData(
            item.title,
            "${item.price} USD",
            item.rating.toFloat(),
            item.picUrl.first(),
            item.logo
        )
    }


    override fun getItemCount(): Int = items.size


    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) TYPE_ITEM else TYPE_ANOTHER_ITEM
    }


    companion object {
        const val TYPE_ITEM = 0
        const val TYPE_ANOTHER_ITEM = 1
    }



    class ViewHolderItem(val biding: ViewholderItemBinding)
        : RecyclerView.ViewHolder(biding.root)

    class ViewHolderAnotherItem(val biding: ViewholderAnotherItemBinding)
        : RecyclerView.ViewHolder(biding.root)
}