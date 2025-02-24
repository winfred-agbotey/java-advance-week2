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
                        .uri("http://localhost:8082"))
                .route("user-service", r -> r.path("/api/v1/users/**")
                        .uri("http://localhost:8081"))
                .build();
    }


}
