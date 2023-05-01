package com.paxier.userservice.controller

import com.paxier.userservice.entity.User
import com.paxier.userservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Month

@RestController
@RequestMapping("api/users")
class UserController(@Autowired val service: UserService) {
    @GetMapping("all")
    fun getAllUser(): Flux<User> {
        return service.getAll()
    }

    @GetMapping("{id}")
    fun getUser(@PathVariable id: Int): Mono<ResponseEntity<User>> {
        return service.getUserById(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createUser(@RequestBody user: User): Mono<User> {
        return service.createUser(user)
    }

    @PutMapping("{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody user: User): Mono<ResponseEntity<User>> {
        return service.updateUser(id, user)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }

    @DeleteMapping("{id}")
    fun deleteUser(@PathVariable id: Int): Mono<ResponseEntity<Void>> {
        return service.deleteUser(id)
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())
    }
}