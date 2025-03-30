package com.example.assignment.brand.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandDeleteDto {
    public record Request(@NotNull Long brandId) {}
}
