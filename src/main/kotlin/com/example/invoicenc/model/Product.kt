package com.example.invoicenc.model


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="product")
class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null


    var descripcion: String?=null

    var brand: String?= null
    var stock: String?= null




}