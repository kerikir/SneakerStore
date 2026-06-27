package com.kerikir.sneakerstore.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kerikir.sneakerstore.databinding.ViewholderBestSellerBinding
import com.kerikir.sneakerstore.model.ItemsModel

class BestSellerAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<BestSellerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BestSellerAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    class ViewHolder(val biding: ViewholderBestSellerBinding)
        : RecyclerView.ViewHolder(biding.root)
}