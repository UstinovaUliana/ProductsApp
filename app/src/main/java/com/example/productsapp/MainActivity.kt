package com.example.productsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapp.adapter.ProductsRecyclerAdapter
import com.example.productsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.Retrofit




@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val myAdapter =  ProductsRecyclerAdapter( this)

        binding.productsRecyclerView.adapter = myAdapter

        binding.productsRecyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://dummyjson.com/products/")
            .build()

/*
        fun collectFlowSafely(
            lifecycleState: Lifecycle.State,
            collect: suspend () -> Unit
        ) {
            this@MainActivity.lifecycleScope.launch {
                this@MainActivity.repeatOnLifecycle(lifecycleState) {
                    collect()
                }
            }
        }

        fun <T : Any> Flow<PagingData<T>>.collectPaging(
            lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
            action: suspend (value: PagingData<T>) -> Unit
        ) {
            collectFlowSafely(lifecycleState) { this.collectLatest { action(it) } }
        }




            viewModel.loadProducts().collectPaging {
                myAdapter.submitData(it)
            }

 */


    }


}