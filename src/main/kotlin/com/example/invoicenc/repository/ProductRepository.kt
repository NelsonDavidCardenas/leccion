package com.example.invoicenc.repository

import com.example.invoicenc.model.Invoice
import com.example.invoicenc.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository :JpaRepository<Product, Long>{
    fun findById(id: Long?) :Product

}