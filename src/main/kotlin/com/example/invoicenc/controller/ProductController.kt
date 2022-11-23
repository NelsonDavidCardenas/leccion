package com.example.invoicenc.controller


import com.example.invoicenc.model.Product
import com.example.invoicenc.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    lateinit var productService: ProductService


    @GetMapping
    fun list():List<Product>{
        return productService.list()



    }

    @PostMapping
    fun save (@RequestBody @Valid product:Product):Product?{
        return productService.save(product)
    }

    @PutMapping
    fun update (@RequestBody product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.update(product), HttpStatus.OK)
    }

    @PatchMapping

    fun updateStock (@RequestBody product:Product):ResponseEntity<Product>{
        return ResponseEntity(productService.updateStock(product), HttpStatus.OK)
    }




}
