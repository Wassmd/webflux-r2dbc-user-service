package com.paxier.userservice.service

import com.paxier.userservice.entity.UserTransaction
import com.paxier.userservice.repository.UserRepository
import com.paxier.userservice.repository.UserTransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class TransactionService(
    @Autowired val userRepository: UserRepository,
    @Autowired val userTransactionRepository: UserTransactionRepository
    ) {

    fun createTransaction(userTransaction: UserTransaction): Mono<UserTransaction> {
        return userRepository.updateUserBalance(userTransaction.userId, userTransaction.amount)
            .filter { it }
            .flatMap { userTransactionRepository.save(userTransaction) }
    }
}