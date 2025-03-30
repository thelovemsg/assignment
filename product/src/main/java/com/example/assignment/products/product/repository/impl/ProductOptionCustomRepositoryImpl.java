package com.example.assignment.products.product.repository.impl;

import com.example.assignment.products.domains.QOptionValue;
import com.example.assignment.products.domains.QProductOption;
import com.example.assignment.products.product.dto.ProductOptionListDto;
import com.example.assignment.products.product.repository.ProductOptionCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductOptionCustomRepositoryImpl implements ProductOptionCustomRepository {

    private final JPAQueryFactory queryFactory;

    final QProductOption productOption = QProductOption.productOption;
    final QOptionValue optionValue = QOptionValue.optionValue;

    @Override
    public List<ProductOptionListDto.Response> findByConditions(ProductOptionListDto.Request request, Pageable pageInfo) {
        return queryFactory.select(
                    Projections.constructor(
                        ProductOptionListDto.Response.class,
                        productOption.productId,
                        productOption.optionName,
                        productOption.displayName.as("optionDisplayName"),
                        productOption.code,
                        productOption.sortOrder.as("optionSortOrder"),
                        optionValue.value,
                        optionValue.displayName.as("valueDisplayName"),
                        optionValue.sortOrder.as("valueSortOrder")
                    )
                )
                .from(productOption)
                .leftJoin(optionValue).on(productOption.productOptionId.eq(optionValue.optionValueId))
                .limit(pageInfo.getPageSize())
                .offset(pageInfo.getOffset())
                .fetch();
    }

    @Override
    public Long countByConditions(ProductOptionListDto.Request request) {
        return queryFactory.select(productOption.count())
                .from(productOption)
                .fetchOne();
    }
}
