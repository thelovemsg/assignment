package com.example.assignment.products.product.repository;

import com.example.assignment.products.product.dto.ProductListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCustomRepository {
    List<ProductListDto.Response> findByConditions(ProductListDto.Request request, Pageable pageable);
    Long countByConditions(ProductListDto.Request request);
}
