package com.example.assignment.products.product.dto;

import com.example.assignment.common.vo.Money;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDetailListDto {
    public record Request(Money startPrice, Money endPrice, String description, Boolean isLastDetail) {}
    public record Response() {}
}
