package com.example.productsapp.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapp.adapter.ProductsRecyclerAdapter
import com.example.productsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = ProductsRecyclerAdapter(this)

        binding.productsRecyclerView.adapter = myAdapter

        binding.productsRecyclerView.layoutManager = LinearLayoutManager(this)

        /*
        myAdapter.setOnClickListener(object: ProductsRecyclerAdapter.OnClickListener {
                        override fun onClick(position: Int, model: Bundle) {
                            val intent = Intent(this@MainActivity, ProductActivity::class.java)
                            intent.putExtra("Product", model)
                            startActivity(intent)
                        }
                    })
         */

        // Observable.create<Int> {


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.loadProducts().collect {
                    Log.d("mytag", "$it")
                    myAdapter.submitData(it)
                }
            }
        }
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


         */


    }

}