package com.example.productsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.productsapp.R

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val product = intent.getSerializableExtra("Product")
    }
}