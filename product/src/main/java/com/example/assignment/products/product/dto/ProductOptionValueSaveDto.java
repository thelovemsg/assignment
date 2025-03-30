package com.example.assignment.products.product.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOptionValueSaveDto {
    public record Request() {}
    public record Response(Long productOptionValueId) {}
}
