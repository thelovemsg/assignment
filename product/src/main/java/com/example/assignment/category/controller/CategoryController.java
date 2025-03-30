package com.example.assignment.category.controller;

import com.example.assignment.category.dto.CategoryDeleteDto;
import com.example.assignment.category.dto.CategoryDetailDto;
import com.example.assignment.category.dto.CategoryListDto;
import com.example.assignment.category.dto.CategorySaveDto;
import com.example.assignment.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/list")
    public ResponseEntity<Page<CategoryListDto.Response>> getProducts(@RequestBody CategoryListDto.Request request, Pageable pageable) {
        Page<CategoryListDto.Response> categories = categoryService.list(request, pageable);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/detail")
    public ResponseEntity<CategoryDetailDto.Response> detail(@Valid @RequestBody CategoryDetailDto.Request request) {
        return ResponseEntity.ok(categoryService.detail(request));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody CategorySaveDto.Request request) {
        return ResponseEntity.ok(categoryService.save(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody CategoryDeleteDto.Request request) {
        categoryService.delete(request);
    }
}
