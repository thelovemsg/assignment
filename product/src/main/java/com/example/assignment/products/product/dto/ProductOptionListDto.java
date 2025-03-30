package com.example.assignment.products.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOptionListDto {
    public record Request(@NotNull Long productId, String optionName, String displayName, String code) {}
    public record Response(Long productId, String optionName, String optionDisplayName, String code,
                           Integer optionSortOrder, String value, String valueDisplayName, Integer valueSortOrder) {}
}
