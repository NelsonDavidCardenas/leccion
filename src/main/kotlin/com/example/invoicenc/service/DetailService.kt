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

    fun calculateAndUpdateTotal (detail : Detail){
        val totalCalculated = detailRepository.sumTotal(detail.invoiceId)
        val invoiceResponse = invoiceRepository.findById(detail.invoiceId)
        invoiceResponse.apply {
           total=totalCalculated
        }
        invoiceRepository.save(invoiceResponse)
    }

    fun save(detail:Detail):Detail{
        try{
            val response= detailRepository.save(detail)
            val responseProduct = productRepository.findById(response.productId)
            responseProduct.apply {
                stock = stock?.minus(detail.quantity!!)
            }
            productRepository.save(responseProduct)
            calculateAndUpdateTotal(response)


            return response

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