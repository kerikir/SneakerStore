package com.kerikir.sneakerstore.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.kerikir.sneakerstore.MainActivity
import com.kerikir.sneakerstore.R
import com.kerikir.sneakerstore.adapter.ListColorsAdapter
import com.kerikir.sneakerstore.databinding.ActivityDetailBinding
import com.kerikir.sneakerstore.helper.ManagmentCart
import com.kerikir.sneakerstore.model.ItemsModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private lateinit var item: ItemsModel
    private var numberOrder = 1

    private lateinit var managementCart: ManagmentCart


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managementCart = ManagmentCart(this)

        getBundle()
        initList()
    }


    private fun getBundle() {
        item = (intent.getSerializableExtra("object") as ItemsModel?)!!

        binding.title.text = item.title
        binding.description.text = item.description
        binding.price.text = "$${item.price}"
        binding.rating.text = item.rating.toString()

        binding.addToCartButton.setOnClickListener {
            item.numberInCart = numberOrder
            managementCart.insertItems(item)
        }
        binding.backButton.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }

        binding.cartButton.setOnClickListener {  }
    }


    private fun initList() {
        val colors = ArrayList<String>()
        for (imageUrl in item.picUrl) {
            colors.add(imageUrl)
        }

        Glide.with(this)
            .load(colors.first())
            .into(binding.picShoes)

        binding.picListColors.adapter = ListColorsAdapter(colors, binding.picShoes)
        binding.picListColors.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
    }
}