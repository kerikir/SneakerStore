package com.kerikir.sneakerstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kerikir.sneakerstore.databinding.ViewholderCartBinding
import com.kerikir.sneakerstore.helper.ChangeNumberItemsListener
import com.kerikir.sneakerstore.helper.ManagmentCart
import com.kerikir.sneakerstore.model.ItemsModel

class CartAdapter(
    private val listItemSelected: ArrayList<ItemsModel>,
    context: Context,
    var changeNumberItemsListener: ChangeNumberItemsListener? = null
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    private val managementCart = ManagmentCart(context)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ViewholderCartBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }


    override fun getItemCount(): Int = listItemSelected.size



    class ViewHolder(
        val binding: ViewholderCartBinding
    ) : RecyclerView.ViewHolder(binding.root)
}