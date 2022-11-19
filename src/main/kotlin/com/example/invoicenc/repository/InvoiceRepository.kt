package com.example.invoicenc.repository

import com.example.invoicenc.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface InvoiceRepository :JpaRepository<Invoice, Long>{
    fun findById(id: Long?) :Invoice?
}