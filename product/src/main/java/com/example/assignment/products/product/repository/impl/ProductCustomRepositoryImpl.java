package com.example.assignment.products.product.repository.impl;

import com.example.assignment.brand.domain.QBrand;
import com.example.assignment.products.domains.QProduct;
import com.example.assignment.products.domains.QProductDetail;
import com.example.assignment.products.product.dto.ProductListDto;
import com.example.assignment.products.product.repository.ProductCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    private final JPAQueryFactory queryFactory;

    final QProduct product = QProduct.product;
    final QProductDetail productDetail = QProductDetail.productDetail;
    final QBrand brand = QBrand.brand;

    QProductDetail subDetail = new QProductDetail("subDetail");

    @Override
    public List<ProductListDto.Response> findByConditions(ProductListDto.Request request, Pageable pageable) {
        return this.queryFactory.select(
                        Projections.constructor(
                                ProductListDto.Response.class,
                                product.productId,
                                product.basePrice,
                                productDetail.version,
                                productDetail.basePrice.as("sellingPrice"),
                                product.productName,
                                brand.brandId,
                                brand.name.as("brandName"),
                                brand.homepageUrl
                        )
                )
                .from(product)
                .leftJoin(productDetail).on(
                    product.productId.eq(productDetail.productId)
                            .and(productDetail.version.eq(
                                    JPAExpressions.select(subDetail.version.max())
                                            .from(subDetail)
                                            .where(subDetail.productId.eq(product.productId))
                            ))

                ).leftJoin(brand).on(brand.brandId.eq(product.brandId))
                .where(containsProductName(request.productName()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countByConditions(ProductListDto.Request request) {
        return this.queryFactory.select(product.count())
                .from(product)
                .where(containsProductName(request.productName()))
                .fetchOne();
    }

    public BooleanExpression containsProductName(String productName) {
        return StringUtils.isNotEmpty(productName) ? product.productName.contains(productName) : null;
    }
}
