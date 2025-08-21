package ru.nikulin.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/test-service/**")
                    .filters(f -> f.stripPrefix(1))
                    .uri("http://host.docker.internal:8081"))
            .route(r -> r.path("/test-service2/**")
                    .filters(f -> f.stripPrefix(1))
                    .uri("http://host.docker.internal:8082"))
            .route(r -> r.path("/test-service3/**")
                    .filters(f -> f.stripPrefix(1))
                    .uri("http://host.docker.internal:8083"))
            .build();

//                .route("zoo_route",
//                        route -> route.path("/zoo/**")
//                                .filters(filter -> filter.stripPrefix(1)
//                                )
//                                .uri("lb://zoo"))

    }
}
