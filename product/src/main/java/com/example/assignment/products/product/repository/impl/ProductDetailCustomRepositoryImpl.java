package com.example.assignment.products.product.repository.impl;

import com.example.assignment.products.product.dto.ProductDetailListDto;
import com.example.assignment.products.product.repository.ProductDetailCustomRepository;
import com.example.assignment.products.product.repository.ProductDetailRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDetailCustomRepositoryImpl implements ProductDetailCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ProductDetailListDto.Response> findByConditions(ProductDetailListDto.Request request, Pageable pageInfo) {
        return null;
    }

    @Override
    public Long countByConditions(ProductDetailListDto.Request request) {
        return null;
    }
}
