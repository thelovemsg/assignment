package com.example.assignment.products.product.controller;

import com.example.assignment.products.domains.ProductCategoryListDto;
import com.example.assignment.products.product.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-category")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/category-list")
    public ResponseEntity<Page<ProductCategoryListDto.Response>> categoryListByProduct(@RequestBody ProductCategoryListDto.Request request, Pageable pageable) {
        Page<ProductCategoryListDto.Response> categoryListByProduct = productCategoryService.categoryList(request, pageable);
        return ResponseEntity.ok(categoryListByProduct);
    }

    @PostMapping("/product-list")
    public ResponseEntity<Page<ProductCategoryListDto.Response>> productListByCategory(@RequestBody ProductCategoryListDto.Request request, Pageable pageable) {
        Page<ProductCategoryListDto.Response> productListByCategory = productCategoryService.productList(request, pageable);
        return ResponseEntity.ok(productListByCategory);
    }

}
