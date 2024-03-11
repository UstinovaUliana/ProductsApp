package com.example.productsapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapp.adapter.ProductsRecyclerAdapter
import com.example.productsapp.databinding.ActivityMainBinding
import com.example.productsapp.model.ProductUI
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = ProductsRecyclerAdapter(this)

        binding.productsRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.productsRecyclerView.adapter = myAdapter

        myAdapter.addLoadStateListener { loadStates ->
            binding.productsRecyclerView.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.productsProgressBar.isVisible = loadStates.refresh is LoadState.Loading
        }

        myAdapter.setOnClickListener(object: ProductsRecyclerAdapter.OnClickListener {
                        override fun onClick(position: Int, model: ProductUI) {
                            val intent = Intent(this@MainActivity, ProductActivity::class.java)
                            intent.putExtra("Product", model)
                            startActivity(intent)
                        }
                    })

        disposable.add(viewModel.loadProducts().subscribe{
            myAdapter.submitData(lifecycle,it)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}