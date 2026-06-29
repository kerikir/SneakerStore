package com.kerikir.sneakerstore.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kerikir.sneakerstore.R
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
    }
}