package com.paxier.userservice.dto

data class TransactionResponseDto(
    val userId: Int,
    val amount: Double,
    val status: TransactionStatus
)
