package com.paxier.userservice.repository

import com.paxier.userservice.entity.User
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveCrudRepository<User, Int> {

    @Modifying
    @Query(
        "update users " +
                "set balance = balance - :amount " +
                "where id = :userId " +
                "and balance >= :amount"
    )
    fun updateUserBalance(userId: Int, amount: Double): Mono<Boolean>
}