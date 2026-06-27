package com.kerikir.sneakerstore

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerikir.sneakerstore.activity.BaseActivity
import com.kerikir.sneakerstore.adapter.BestSellerAdapter
import com.kerikir.sneakerstore.adapter.CategoryAdapter
import com.kerikir.sneakerstore.databinding.ActivityMainBinding
import com.kerikir.sneakerstore.viewModel.MainViewModel

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel = MainViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategories()
        initBestSellers()
    }


    private fun initCategories() {
        binding.progressBarCategory.visibility = View.VISIBLE

        viewModel.category.observe(this, Observer {

            binding.recyclerViewCategory.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            binding.recyclerViewCategory.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility = View.GONE
        })
    }


    private fun initBestSellers() {
        binding.progressBarBestseller.visibility = View.VISIBLE

        viewModel.bestSeller.observe(this, Observer {
            binding.recyclerViewBestseller.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            binding.recyclerViewBestseller.adapter = BestSellerAdapter(it)

            binding.progressBarBestseller.visibility = View.GONE
        })
    }
}