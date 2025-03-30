package com.example.assignment.products.product.repository.impl;

import com.example.assignment.products.domains.ProductCategoryListDto;
import com.example.assignment.products.product.repository.ProductCategoryCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductCategoryCustomRepositoryImpl implements ProductCategoryCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ProductCategoryListDto.Response> findCategoryByConditions(ProductCategoryListDto.Request request, Pageable pageable) {
        return null;
    }

    @Override
    public Long countCategoryByConditions(ProductCategoryListDto.Request request) {
        return null;
    }

    @Override
    public List<ProductCategoryListDto.Response> findProductByConditions(ProductCategoryListDto.Request request, Pageable pageable) {
        return null;
    }

    @Override
    public Long countProductByConditions(ProductCategoryListDto.Request request) {
        return null;
    }
}
