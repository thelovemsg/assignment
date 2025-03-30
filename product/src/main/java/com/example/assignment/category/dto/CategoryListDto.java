package com.example.assignment.category.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryListDto {
    public record Request(Long parentId) {}
    @Builder
    public record Response(Long categoryId, String categoryName, Long parentId, String parentName) {}
}
