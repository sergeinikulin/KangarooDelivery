package ru.nikulin.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
//                .route("random_animal_route",
//                        route -> route.path("/random-animal/**")
//                                .and()
//                                .method(HttpMethod.GET)
//                                .filters(filter -> filter.stripPrefix(1)
//                                )
//                                .uri("lb://random-animal"))


                .route("test-service",
                        r -> r.path("/test-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8081"))

//                .route("zoo_route",
//                        route -> route.path("/zoo/**")
//                                .filters(filter -> filter.stripPrefix(1)
//                                )
//                                .uri("lb://zoo"))
                .build();
    }
}
