package com.example.productsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.productsapp.R
import com.example.productsapp.databinding.ActivityProductBinding
import com.example.productsapp.model.ProductUI

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityProductBinding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("Product") as ProductUI

        binding.itemTitleTextView.text = product.title
        Glide.with(this)
            .load(product.images[0])
            .into(binding.itemImageView)
        binding.itemDescriptionTextView.text = product.description
        binding.itemPriceTextView.text = "${binding.itemPriceTextView.text}: ${product.price}$"
        binding.itemRatingTextView.text = "${binding.itemRatingTextView.text}: ${product.rating}"

    }
}