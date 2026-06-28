package com.kerikir.sneakerstore.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kerikir.sneakerstore.adapter.ListItemsAdapter
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
        initList()
    }


    private fun getBundle() {
        id = intent.getStringExtra("id")!!
        title = intent.getStringExtra("title")!!

        binding.category.text = title
    }


    private fun initList() {
        binding.apply {
            progressBarList.visibility = View.VISIBLE
            viewModel.loadItems(id).observe(this@ListItemsActivity, Observer {
                listItems.layoutManager = LinearLayoutManager(
                    this@ListItemsActivity, LinearLayoutManager.VERTICAL, false
                )
                listItems.adapter = ListItemsAdapter(it)
                progressBarList.visibility = View.GONE
            })

            backButton.setOnClickListener { finish() }
        }
    }
}