package com.kerikir.sneakerstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        val item = listItemSelected[position]

        holder.binding.title.text = item.title
        holder.binding.feeEachItem.text = "$${item.price}"
        holder.binding.totalEachItem.text = "$${Math.round(item.numberInCart * item.price)}"
        holder.binding.numberItem.text = item.numberInCart.toString()

        Glide.with(holder.itemView.context)
            .load(item.picUrl[0])
            .into(holder.binding.picCart)

        holder.binding.plusCartButton.setOnClickListener {
            managementCart.plusItem(listItemSelected, position, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener?.onChanged()
                }
            })
        }
        holder.binding.minusCartButton.setOnClickListener {
            managementCart.minusItem(listItemSelected, position, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener?.onChanged()
                }
            })
        }
    }


    override fun getItemCount(): Int = listItemSelected.size



    class ViewHolder(
        val binding: ViewholderCartBinding
    ) : RecyclerView.ViewHolder(binding.root)
}