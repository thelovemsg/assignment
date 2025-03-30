package com.example.assignment.products.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionValueSaveDto {
    public record Request(@NotNull Long productOptionId, Long optionValueId, String value, String displayName,
                          String description, Integer sortOrder) {}
    public record Response(Long optionValueId) {}
}
