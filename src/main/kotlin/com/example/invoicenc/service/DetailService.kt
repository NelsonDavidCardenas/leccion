package com.example.invoicenc.service

import com.example.invoicenc.model.Detail
import com.example.invoicenc.repository.DetailRepository
import com.example.invoicenc.repository.InvoiceRepository
import com.example.invoicenc.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository
    @Autowired
    lateinit var productRepository: ProductRepository
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository


    fun list():List<Detail>{
        return detailRepository.findAll()

    }

    fun save(detail:Detail):Detail{
        try{
            invoiceRepository.findById(detail.invoiceId)
                ?:throw Exception("El id ${detail.invoiceId} de factura no existe")
            return detailRepository.save(detail)
            productRepository.findById(detail.productId)
                ?:throw Exception("El id ${detail.productId} de detalle no existe")
            return detailRepository.save(detail)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }


    }

    fun update(detail: Detail):Detail {
        try {
            detailRepository.findById(detail.id)
                ?: throw Exception("Id no existe")
            return detailRepository.save(detail)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }


    }
    fun updateQuantity(detail:Detail): Detail {
        try{
            val response = detailRepository.findById(detail.id)
                ?: throw Exception("ID no existe")
            response.apply {
                quantity=detail.quantity
            }
            return detailRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }






}