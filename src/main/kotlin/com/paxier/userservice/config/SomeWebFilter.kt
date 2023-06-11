package com.paxier.userservice.config

import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class SomeWebFilter: WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        Logger.info("WebFilter Executing pre-processing logic")

        return chain.filter(exchange)
    }

    companion object {
            private val Logger = LoggerFactory.getLogger(SomeWebFilter::class.java)
    }
}