package com.example.assignment.products.product.service;

import com.example.assignment.products.product.dto.ProductItemDeleteDto;
import com.example.assignment.products.product.dto.ProductItemDetailDto;
import com.example.assignment.products.product.dto.ProductItemListDto;
import com.example.assignment.products.product.dto.ProductItemAddDto;
import com.example.assignment.products.product.repository.ProductItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductItemService {

    private final ProductItemRepository productItemRepository;

    public Page<ProductItemListDto.Response> list(ProductItemListDto.Request request, Pageable pageable) {
        return null;
    }

    public ProductItemDetailDto.Response detail(ProductItemDetailDto.Request request) {
        return null;
    }

    @Transactional
    public Long save(ProductItemAddDto.Request request) {
        return null;
    }

    @Transactional
    public void delete(ProductItemDeleteDto.Request request) {
    }
}
