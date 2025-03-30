package com.example.assignment.products.product.controller;

import com.example.assignment.products.product.dto.*;
import com.example.assignment.products.product.service.OptionValueService;
import com.example.assignment.products.product.service.ProductOptionService;
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
@RequestMapping("/api/product-option")
@RequiredArgsConstructor
public class ProductOptionController {

    private final ProductOptionService productOptionService;
    private final OptionValueService optionValueService;

    @PostMapping("list")
    public ResponseEntity<Page<ProductOptionListDto.Response>> list(@Valid @RequestBody ProductOptionListDto.Request request, Pageable pageable) {
        return ResponseEntity.ok(productOptionService.list(request, pageable));
    }

    @PostMapping("/detail")
    public ResponseEntity<ProductOptionDetailDto.Response> detail(@Valid @RequestBody ProductOptionDetailDto.Request request) {
        return ResponseEntity.ok(productOptionService.detail(request));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody ProductOptionSaveDto.Request request) {
        return ResponseEntity.ok(productOptionService.save(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody ProductOptionDeleteDto.Request request) {
        productOptionService.delete(request);
    }

}
