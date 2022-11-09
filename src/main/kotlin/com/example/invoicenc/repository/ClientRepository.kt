package com.example.invoicenc.repository

import com.example.invoicenc.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ClientRepository :JpaRepository<Client, Long>{
}