package com.mawulidev.apigateway.config;


import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import java.util.function.Predicate;

@Component
public class CustomHeaderPredicateFactory extends AbstractRoutePredicateFactory<CustomHeaderPredicateFactory.Config> {
    public static class Config {
        private String headerName;
        public String getHeaderName() { return headerName; }
        public void setHeaderName(String headerName) { this.headerName = headerName; }
    }

    public CustomHeaderPredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> exchange.getRequest().getHeaders().containsKey(config.getHeaderName());
    }
}
