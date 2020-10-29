package com.collux.platform.polestar

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
open class ColluxPolestarApplication

fun main(args: Array<String>) {
    runApplication<ColluxPolestarApplication>(*args)
}
