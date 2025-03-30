package com.example.assignment.products.domains;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductCategoryListDto {
    public record Request() {}
    public record Response() {}
}
