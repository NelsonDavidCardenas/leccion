package com.example.invoicenc.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


@Entity
@Table(name="client")
class Client {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Obligatorio")
    var nui :String?=null
    @NotBlank(message="Obligatorio")
    var fullname :String?=null

    var adress :String?=null

}