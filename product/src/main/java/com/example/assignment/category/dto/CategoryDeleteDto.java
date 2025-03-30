package com.example.assignment.category.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDeleteDto {
    public record Request(@NotNull Long categoryId) {}
}
