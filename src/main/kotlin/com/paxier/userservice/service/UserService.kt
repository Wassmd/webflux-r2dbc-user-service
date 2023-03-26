package com.paxier.userservice.service

import com.paxier.userservice.entity.User
import com.paxier.userservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(@Autowired val userRepository: UserRepository) {

    fun getAll(): Flux<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: Int): Mono<User> {
        return userRepository.findById(id)
    }

    fun createUser(user: User): Mono<User> {
        return userRepository.save(user)
    }

    fun updateUser(id: Int, user: User): Mono<User> {
        return userRepository.findById(id).flatMap {
            it.balance = user.balance

            userRepository.save(it)
        }
    }

    fun deleteUser(id: Int): Mono<Void> {
        return userRepository.deleteById(id)
    }
}