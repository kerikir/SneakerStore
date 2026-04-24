package com.kerikir.sneakerstore.activity

import android.content.Intent
import android.os.Bundle
import com.kerikir.sneakerstore.MainActivity
import com.kerikir.sneakerstore.databinding.ActivityInitialBinding

class InitialActivity : BaseActivity() {

    lateinit var binding: ActivityInitialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonStart.setOnClickListener {
                startActivity(Intent(this@InitialActivity, MainActivity::class.java))
            }
        }
    }
}