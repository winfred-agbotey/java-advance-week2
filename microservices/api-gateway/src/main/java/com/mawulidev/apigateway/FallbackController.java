package com.mawulidev.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RestController
public class FallbackController {
    private final Logger logger = Logger.getLogger(FallbackController.class.getName());

    @RequestMapping("/fallback")
    public Mono<String> fallback(ServerWebExchange exchange) {
        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        String routeId = (route != null) ? route.getId() : "Unknown Route";
        logger.warning(routeId + ": is temporarily unavailable. Please try again later");
        return Mono.just(routeId + ": is temporarily unavailable. Please try again later");
    }
}
