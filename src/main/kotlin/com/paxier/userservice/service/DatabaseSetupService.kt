package com.paxier.userservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.core.io.Resource
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Service
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

@Service
class DatabaseSetupService(@Value("classpath:h2/init.sql") var initSql: Resource, @Autowired val entityTemplate: R2dbcEntityTemplate): CommandLineRunner {

    override fun run(vararg args: String?) {
        val query = StreamUtils.copyToString(initSql.inputStream, StandardCharsets.UTF_8)
        println("Query:$query")
        entityTemplate.databaseClient.sql(query).then().subscribe()
    }
}