package com.example.invoicenc.service

import com.example.invoicenc.model.Product
import com.example.invoicenc.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository


    fun list():List<Product>{
        return productRepository.findAll()

    }

    fun save(product:Product):Product{
        return productRepository.save(product)
    }

    fun update(product: Product):Product {
        try {
            productRepository.findById(product.id)
                ?: throw Exception("Id no existe")
            return productRepository.save(product)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }


    }
    fun updateStock(product:Product): Product {
        try{
            val response = productRepository.findById(product.id)
                ?: throw Exception("ID no existe")
            response.apply {
                stock=product.stock
            }
            return productRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }






}