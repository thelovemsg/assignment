package com.example.assignment.category.repository;

import com.example.assignment.category.dto.CategoryListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryCustomRepository {
    List<CategoryListDto.Response>  findByConditions(CategoryListDto.Request request, Pageable pageable);
    Long countByConditions(CategoryListDto.Request request);
    boolean existsByParentCategoryId(Long categoryId);
}
