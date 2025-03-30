package com.example.assignment.products.product.dto;

import com.example.assignment.common.vo.Money;
import com.example.assignment.products.domains.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDetailDto {
    public record Request(Long productId) {}
    @Builder
    public record Response(Long productId, String productName, Money basePrice, String productStatus) {
        public static Response fromEntity(Product product) {
            return Response.builder()
                    .productId(product.getProductId())
                    .productName(product.getProductName())
                    .basePrice(product.getBasePrice())
                    .productStatus(product.getProductStatus().toString())
                    .build();
        }
    }
}
