package com.example.assignment.products.product.controller;

import com.example.assignment.products.product.dto.ProductDeleteDto;
import com.example.assignment.products.product.dto.ProductDetailDto;
import com.example.assignment.products.product.dto.ProductListDto;
import com.example.assignment.products.product.dto.ProductSaveDto;
import com.example.assignment.products.product.service.ProductService;
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
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/list")
    public ResponseEntity<Page<ProductListDto.Response>> list(@RequestBody ProductListDto.Request request, Pageable pageable) {
        Page<ProductListDto.Response> Products = productService.list(request, pageable);
        return ResponseEntity.ok(Products);
    }

    @PostMapping("/detail")
    public ResponseEntity<ProductDetailDto.Response> detail(@Valid @RequestBody ProductDetailDto.Request request) {
        return ResponseEntity.ok(productService.detail(request));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody ProductSaveDto.Request request) {
        return ResponseEntity.ok(productService.save(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody ProductDeleteDto.Request request) {
        productService.delete(request);
    }
}
