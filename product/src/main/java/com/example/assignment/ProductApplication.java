package com.example.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.*;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "com.example.assignment")
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
