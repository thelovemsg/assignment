package com.example.assignment.products.product.service;

import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.products.domains.ProductCategoryListDto;
import com.example.assignment.products.product.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public Page<ProductCategoryListDto.Response> categoryList(ProductCategoryListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> productCategoryRepository.findCategoryByConditions(request, pageInfo),
                () -> productCategoryRepository.countCategoryByConditions(request));
    }

    public Page<ProductCategoryListDto.Response> productList(ProductCategoryListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> productCategoryRepository.findProductByConditions(request, pageInfo),
                () -> productCategoryRepository.countProductByConditions(request));
    }
}
