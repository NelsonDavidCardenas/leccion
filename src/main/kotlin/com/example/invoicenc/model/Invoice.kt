package com.example.invoicenc.model

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name="invoice")
class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    @NotBlank(message="Obligatorio")
    var code: String?= null

    @Column(name="create_at")
    var createAt: Date?=null

    var total: Double?= null

    @Column(name="client_id")
    var clientId: Long? = null

}