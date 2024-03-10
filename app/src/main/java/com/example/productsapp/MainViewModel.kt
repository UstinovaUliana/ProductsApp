package com.example.productsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.domain.usecase.LoadProductsUseCase
import com.example.productsapp.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val loadProductsUseCase: LoadProductsUseCase) :
    ViewModel() {

    fun <T : Any, S : Any> Flow<PagingData<T>>.collectPagingRequest(
        mappedData: (T) -> S
    ) = map { it.map { data -> mappedData(data) } }.cachedIn(viewModelScope)

    fun loadProducts() = loadProductsUseCase().collectPagingRequest { it.toUI() }

//init{
/*
        Observable.just(ProductsRepositoryImpl.loadProducts())
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .subscribe(this)

 */

    /*
    viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val cats = catsRepos.getCats(CatsRequest(10))
            _items.postValue(cats)
        }
    }
     */
//    }


}