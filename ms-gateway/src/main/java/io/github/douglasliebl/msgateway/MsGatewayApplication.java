package io.github.douglasliebl.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

// Gateway que utiliza a porta 8080 onde todos microservices estão conectados;
@SpringBootApplication
@EnableDiscoveryClient
public class MsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/clients/**").uri("lb://ms-client")) // Rota para o microservice de clientes, criação de usuário etc..;
				.route(r -> r.path("/cards/**").uri("lb://ms-card")) // Rota para o microservice de cartões, adição de cartões etc..;
				.route(r -> r.path("/appraiser/**").uri("lb://ms-appraiser")) // Rota para o microservice de avaliação, avaliação de disponibilidade de cartão etc..;
				.build();
	}
}
