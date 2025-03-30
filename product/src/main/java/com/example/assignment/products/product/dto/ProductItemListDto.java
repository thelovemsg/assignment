package com.example.assignment.products.product.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductItemListDto {
    public record Request(Long productItemId){}
    public record Response() {}
}
