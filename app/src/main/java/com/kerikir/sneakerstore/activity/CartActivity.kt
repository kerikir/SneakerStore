package com.kerikir.sneakerstore.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerikir.sneakerstore.R
import com.kerikir.sneakerstore.adapter.CartAdapter
import com.kerikir.sneakerstore.databinding.ActivityCartBinding
import com.kerikir.sneakerstore.helper.ChangeNumberItemsListener
import com.kerikir.sneakerstore.helper.ManagmentCart

class CartActivity : BaseActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var managementCart: ManagmentCart
    private var tax: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managementCart = ManagmentCart(this)

        setVariable()
        initCartList()
        calculateCart()
    }


    private fun calculateCart() {
        val percentTax = 0.02
        val delivery = 15.0
        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100) / 100.0
        val total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100) / 100.0
        val itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100.0

        binding.totalFee.text = "$$itemTotal"
        binding.tax.text = "$$tax"
        binding.delivery.text = "$$delivery"
        binding.total.text = "$$total"
    }


    private fun setVariable() {
        binding.backButton.setOnClickListener { finish() }
    }


    private fun initCartList() {
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        binding.cartRecyclerView.adapter = CartAdapter(
            managementCart.getListCart(), this, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    calculateCart()
                }
            }
        )
    }
}