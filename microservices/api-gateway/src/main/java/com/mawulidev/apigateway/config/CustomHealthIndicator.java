//package com.mawulidev.apigateway.config;
//
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomHealthIndicator implements HealthIndicator {
//    @Override
//    public Health health() {
//        boolean serviceHealthy = checkServiceHealth();
//        if (serviceHealthy) {
//            return Health.up().withDetail("Service Status", "Running smoothly").build();
//        }
//        return Health.down().withDetail("Service Status", "Issues detected").build();
//    }
//
//    private boolean checkServiceHealth() {
//        // Custom logic to determine service health
//        return true;  // Simulating a healthy service
//    }
//}
