package com.mawulidev.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayRoutes {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("blog-service", r -> r.path("/api/v1/blog/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("blog-service")
                                .setFallbackUri("forward:/fallback")))
                        .uri("http://localhost:8082")
                )
                .route("user-service", r -> r.path("/api/v1/users/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("user-service")
                                .setFallbackUri("forward:/fallback")))
                        .uri("http://localhost:8081"))
                .build();
    }


}
