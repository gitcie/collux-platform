package com.collux.platform.register

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
open class ColluxServiceRegisterApplication

fun main(args: Array<String>) {
    runApplication<ColluxServiceRegisterApplication>(*args);
}