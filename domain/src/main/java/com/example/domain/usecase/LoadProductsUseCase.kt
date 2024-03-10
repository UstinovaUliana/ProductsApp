package com.example.domain.usecase

import com.example.domain.repositories.ProductsRepository
import javax.inject.Inject

class LoadProductsUseCase @Inject constructor (private val repository: ProductsRepository) {

    operator fun invoke() = repository.loadProducts()

}