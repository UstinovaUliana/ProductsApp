package com.example.productsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProductsFragment : Fragment() {
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: MainViewModel by viewModels()

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



    }

 */

 */
}