package com.example.productsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapp.adapter.ProductsRecyclerAdapter
import com.example.productsapp.databinding.ActivityMainBinding
import com.example.productsapp.model.Product

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productsRecyclerView.adapter =
            ProductsRecyclerAdapter(getProducts(), this)
        binding.productsRecyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun getProducts() = arrayListOf(
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        Product(
            "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
            "iPhone 9",
            "An apple mobile which is nothing like apple"
        ),
        )
}