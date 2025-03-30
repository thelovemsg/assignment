package com.example.assignment.category.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategorySaveDto {
    public record Request(Long parentId, @NotBlank String name) {}
    @Builder
    public record Response(Long categoryId) {}
}
