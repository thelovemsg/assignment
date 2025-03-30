package com.example.assignment.products.product.dto;

import com.example.assignment.common.vo.Money;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductListDto {
    public record Request(String productName, String brandName, Money startBasePrice, Money endBasePrice) {}
    public record Response(Long productId, Money basePrice, String version, Money sellingPrice,
                           String productName, Long brandId, String brandName, String homepageUrl) {}
}
