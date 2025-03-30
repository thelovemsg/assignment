package com.example.assignment.common.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private final String BASIC_PACKAGE_PATH = "com.example.assignment.";

    @Bean
    public GroupedOpenApi brandApi() {
        return GroupedOpenApi.builder()
                .group("Brand")
                .packagesToScan(BASIC_PACKAGE_PATH + "brand.controller")
                .pathsToMatch("/api/brand/**")
                .build();
    }

    @Bean
    public GroupedOpenApi memberApi() {
        return GroupedOpenApi.builder()
                .group("Member")
                .packagesToScan(BASIC_PACKAGE_PATH + "member.controller")
                .pathsToMatch("/api/member/**")
                .build();
    }

    @Bean
    public GroupedOpenApi productApi() {
        return GroupedOpenApi.builder()
                .group("Product")
                .packagesToScan(BASIC_PACKAGE_PATH + "product.controller")
                .pathsToMatch("/api/product/**")
                .build();
    }

    @Bean
    public GroupedOpenApi categoryApi() {
        return GroupedOpenApi.builder()
                .group("Category")
                .packagesToScan(BASIC_PACKAGE_PATH + "category.controller")
                .pathsToMatch("/api/category/**")
                .build();
    }
}
