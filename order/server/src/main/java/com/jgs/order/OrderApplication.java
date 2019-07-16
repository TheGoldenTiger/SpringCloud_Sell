package com.imooc.order;

import com.imooc.order.message.StreamClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/*@SpringBootApplication()
@EnableDiscoveryClient
@EnableCircuitBreaker*/
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.imooc.product.client")
@EnableBinding(StreamClient.class)
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}

