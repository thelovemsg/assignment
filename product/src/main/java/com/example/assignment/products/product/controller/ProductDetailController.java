package com.example.assignment.products.product.controller;

import com.example.assignment.products.product.dto.*;
import com.example.assignment.products.product.service.ProductDetailService;
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
@RequestMapping("/api/product-detail")
@RequiredArgsConstructor
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    @PostMapping("/list")
    public ResponseEntity<Page<ProductDetailListDto.Response>> list(@RequestBody ProductDetailListDto.Request request, Pageable pageable) {
        Page<ProductDetailListDto.Response> list = productDetailService.list(request, pageable);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/detail")
    public ResponseEntity<ProductDetailDetailDto.Response> detail(@Valid @RequestBody ProductDetailDetailDto.Request request) {
        return ResponseEntity.ok(productDetailService.detail(request));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody @Valid ProductDetailSaveDto.Request request) {
        return ResponseEntity.ok(productDetailService.save(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody ProductDetailDeleteDto.Request request) {
        productDetailService.delete(request);
    }
}
