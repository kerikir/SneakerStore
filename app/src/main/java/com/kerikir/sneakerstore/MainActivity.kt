package com.kerikir.sneakerstore

import android.os.Bundle
import com.kerikir.sneakerstore.activity.BaseActivity
import com.kerikir.sneakerstore.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}