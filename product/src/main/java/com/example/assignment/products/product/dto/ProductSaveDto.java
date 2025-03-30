package com.example.assignment.products.product.dto;

import com.example.assignment.common.enums.ProductStatusEnum;
import com.example.assignment.common.vo.Money;
import com.example.assignment.products.domains.Product;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductSaveDto {
    public record Request(Long productId, String productName, Money basePrice, ProductStatusEnum productStatus, Long brandId) {
        public Product toEntity() {
            return Product.builder()
                    .productId(this.productId)
                    .productName(this.productName)
                    .basePrice(this.basePrice)
                    .productStatus(this.productStatus)
                    .brandId(this.brandId)
                    .build();
        }
    }
    public record Response() {}
}