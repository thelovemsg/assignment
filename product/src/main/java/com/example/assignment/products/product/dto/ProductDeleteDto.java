package com.example.assignment.products.product.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDeleteDto {
    public record Request(Long productId) {}
}
