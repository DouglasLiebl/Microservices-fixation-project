package io.github.douglasliebl.msappraiser;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // Serve para habilitar a comunicação com outros microservices;
@EnableRabbit
public class MsAppraiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAppraiserApplication.class, args);
	}

}
