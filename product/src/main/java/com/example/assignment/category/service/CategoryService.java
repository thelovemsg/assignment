package com.example.assignment.category.service;

import com.example.assignment.category.dto.CategoryDeleteDto;
import com.example.assignment.category.dto.CategoryDetailDto;
import com.example.assignment.category.dto.CategorySaveDto;
import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.category.dto.CategoryListDto;
import com.example.assignment.category.domain.Category;
import com.example.assignment.category.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Page<CategoryListDto.Response> list(CategoryListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> categoryRepository.findByConditions(request, pageInfo),
                () -> categoryRepository.countByConditions(request));
    }

    public CategoryDetailDto.Response detail(CategoryDetailDto.Request request) {
        Category category = categoryRepository.findById(request.categoryId()).orElseThrow(() -> new NotFoundException(MessageCode.CATEGORY_NOT_FOUND, request.categoryId()));
        return CategoryDetailDto.Response.fromEntity(category);
    }

    @Transactional
    public Long save(CategorySaveDto.Request request) {
        Category category = Category.builder().name(request.name()).build();

        if (request.parentId() != null) {
            Category parent = categoryRepository.findById(request.parentId())
                    .orElseThrow(() -> new NotFoundException(MessageCode.CATEGORY_PARENT_NOT_FOUND, request.parentId()));
            category.settingParent(parent);
        }

        return categoryRepository.save(category).getCategoryId();
    }

    @Transactional
    public void delete(CategoryDeleteDto.Request request) {
        Long categoryId = request.categoryId();

        categoryRepository.findById(categoryId).orElseThrow(() -> new NotFoundException(MessageCode.CATEGORY_NOT_FOUND, categoryId));

        // 하위 카테고리 존재 여부 체크
        boolean hasChildren = categoryRepository.existsByParentCategoryId(categoryId);
        if (hasChildren) {
            throw new NotFoundException(MessageCode.CATEGORY_CHILD_EXISTS, categoryId);
        }

        categoryRepository.deleteById(categoryId);
    }
}
