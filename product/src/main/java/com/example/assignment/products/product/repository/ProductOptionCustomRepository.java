package com.example.assignment.products.product.repository;

import com.example.assignment.products.product.dto.ProductOptionListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductOptionCustomRepository {
    List<ProductOptionListDto.Response> findByConditions(ProductOptionListDto.Request request, Pageable pageInfo);
    Long countByConditions(ProductOptionListDto.Request request);
}
