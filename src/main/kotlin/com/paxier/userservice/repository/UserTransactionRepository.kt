package com.paxier.userservice.repository

import com.paxier.userservice.entity.UserTransaction
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserTransactionRepository: ReactiveCrudRepository<UserTransaction, Int> {
}