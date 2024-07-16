package com.lovebugs.service_discovery

import com.netflix.discovery.EurekaClient
import jakarta.annotation.PreDestroy
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class ServiceDiscoveryApplication(private val eurekaClient: EurekaClient) {
	@PreDestroy
	fun unregister() {
		eurekaClient.shutdown()
	}
}

fun main(args: Array<String>) {
	runApplication<ServiceDiscoveryApplication>(*args)
}
