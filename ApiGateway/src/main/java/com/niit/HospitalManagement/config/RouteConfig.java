/*
 * Author Name: Philip Meshach
 * Date: 10-01-2023
 * Praise The Lord
 */
package com.niit.HospitalManagement.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class RouteConfig {
    @Bean
    public RouteLocator route(RouteLocatorBuilder locatorBuilder){
        return locatorBuilder.routes().route(p-> p.path("/api/v1/**")
                        .uri("lb://userAuth"))
                .route(p->p.path("/Api/V1/**").uri("lb://hospitalManagement")).build();
    }
}
