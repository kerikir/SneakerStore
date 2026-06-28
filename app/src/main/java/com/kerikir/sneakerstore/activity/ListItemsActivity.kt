package com.kerikir.sneakerstore.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kerikir.sneakerstore.R
import com.kerikir.sneakerstore.databinding.ActivityListItemsBinding
import com.kerikir.sneakerstore.viewModel.MainViewModel

class ListItemsActivity : AppCompatActivity() {

    lateinit var binding: ActivityListItemsBinding
    private val viewModel = MainViewModel()
    private var id: String = ""
    private var title: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()

    }


    private fun getBundle() {
        id = intent.getStringExtra("id")!!
        title = intent.getStringExtra("title")!!

        binding.category.text = title
    }
}