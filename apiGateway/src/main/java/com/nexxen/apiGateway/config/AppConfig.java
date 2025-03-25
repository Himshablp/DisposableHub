package com.nexxen.apiGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("auction-service-route", r -> r
                        .path("/auction/**")  //  Match all requests starting with /auction/
                        .filters(f -> f.rewritePath("/auction/(?<segment>.*)", "/${segment}"))  //  Remove /auction/ prefix
                        .uri("lb://auctionService")  //  Load balance to AuctionService via Eureka
                )
                .build();
    }
}
