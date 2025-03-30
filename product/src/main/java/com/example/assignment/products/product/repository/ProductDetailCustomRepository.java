package com.example.assignment.products.product.repository;

import com.example.assignment.products.product.dto.ProductDetailListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDetailCustomRepository {
    List<ProductDetailListDto.Response> findByConditions(ProductDetailListDto.Request request, Pageable pageInfo);
    Long countByConditions(ProductDetailListDto.Request request);
}
