package com.example.productsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import androidx.paging.rxjava2.cachedIn
import com.example.domain.usecase.LoadProductsUseCase
import com.example.productsapp.model.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Flowable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val loadProductsUseCase: LoadProductsUseCase) :
    ViewModel() {

    fun <T : Any, S : Any> Flowable<PagingData<T>>.collectPagingRequest(
        mappedData: (T) -> S
    ) = map { it.map { data -> mappedData(data) } }.cachedIn(viewModelScope)

    fun loadProducts() = loadProductsUseCase().collectPagingRequest { it.toUI() }

}