package com.paxier.userservice.entity

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class UserTransaction(
    @Id
    val id: Int,
    val userId: Int,
    val amount: Double
)
