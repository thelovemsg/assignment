package com.example.assignment.products.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionValueDeleteDto {
    public record Request(@NotNull Long optionValueId) {}
}
