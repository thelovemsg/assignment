package com.example.assignment.products.product.repository;

import com.example.assignment.products.domains.ProductCategoryListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCategoryCustomRepository {
    List<ProductCategoryListDto.Response> findCategoryByConditions(ProductCategoryListDto.Request request, Pageable pageable);
    Long countCategoryByConditions(ProductCategoryListDto.Request request);

    List<ProductCategoryListDto.Response> findProductByConditions(ProductCategoryListDto.Request request, Pageable pageable);
    Long countProductByConditions(ProductCategoryListDto.Request request);
}
