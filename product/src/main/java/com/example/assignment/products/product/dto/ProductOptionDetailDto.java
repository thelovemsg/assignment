package com.example.assignment.products.product.dto;

import com.example.assignment.products.domains.ProductOption;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOptionDetailDto {
    public record Request(Long productOptionId) {}
    @Builder
    public record Response(Long productOptionId, String optionName, String displayName, String code,
                           Integer sortOrder, LocalDateTime createdDateTime, LocalDateTime modifyDateTime) {
        public static Response fromEntity(ProductOption productOption) {
            return null;
        }
    }
}