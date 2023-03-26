package com.paxier.userservice.controller

import com.paxier.userservice.entity.UserTransaction
import com.paxier.userservice.service.TransactionService
import com.paxier.userservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/user-transaction")
class UserTransactionController(
    @Autowired val userService: UserService,
    @Autowired val transactionService: TransactionService
    ) {
    @GetMapping
    fun createTransaction(@RequestBody userTransaction: UserTransaction): Mono<UserTransaction> {
        return transactionService.createTransaction(userTransaction)
    }
}
