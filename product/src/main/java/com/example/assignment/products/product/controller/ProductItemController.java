package com.example.assignment.products.product.controller;

import com.example.assignment.products.product.dto.*;
import com.example.assignment.products.product.manager.ProductItemManager;
import com.example.assignment.products.product.service.ProductItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "상품 아이템 관리", description = "실제로 고객이 구매할 수 있는 상품 정보를 관리하는 Controller 입니다.")
@RestController
@RequestMapping("/api/product-item")
@RequiredArgsConstructor
public class ProductItemController {

    private final ProductItemManager productItemManager;
    private final ProductItemService productItemService;

    @Operation(summary = "상품 아이템 목록 조회", description = "상품 아이템 목록을 조회합니다.")
    @PostMapping("/list")
    public ResponseEntity<Page<ProductItemListDto.Response>> getProducts(@RequestBody @Valid ProductItemListDto.Request request, Pageable pageable) {
        Page<ProductItemListDto.Response> categories = productItemService.list(request, pageable);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/detail")
    public ResponseEntity<ProductItemDetailDto.Response> detail(@Valid @RequestBody ProductItemDetailDto.Request request) {
        return ResponseEntity.ok(productItemService.detail(request));
    }

    @Operation(summary = "상품 아이템 정보 저장", description = "상품 아이템 정보를 저장합니다.")
    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody @Valid ProductItemAddDto.Request request) {
        return ResponseEntity.ok(productItemManager.saveProductItem(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody ProductItemDeleteDto.Request request) {
        productItemService.delete(request);
    }
}
