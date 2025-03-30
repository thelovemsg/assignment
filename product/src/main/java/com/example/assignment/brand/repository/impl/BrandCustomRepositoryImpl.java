package com.example.assignment.brand.repository.impl;

import com.example.assignment.brand.controller.dto.BrandListDto;
import com.example.assignment.brand.domain.QBrand;
import com.example.assignment.brand.repository.BrandCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class BrandCustomRepositoryImpl implements BrandCustomRepository {

    private final JPAQueryFactory queryFactory;

    final QBrand brand = QBrand.brand;

    @Override
    public List<BrandListDto.Response> findByConditions(BrandListDto.Request request, Pageable pageable) {
            return queryFactory.select(
                    Projections.constructor(
                        BrandListDto.Response.class,
                        brand.brandId,
                        brand.name,
                        brand.description,
                        brand.homepageUrl
                    )
                )
                .from(brand)
                .where(
                        likeName(request.name())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countByConditions(BrandListDto.Request request) {
        return queryFactory.select(brand.count())
                .from(brand)
                .where(
                        likeName(request.name())
                )
                .fetchOne();
    }

    public BooleanExpression likeName(String name) {
        return StringUtils.isEmpty(name) ? brand.name.likeIgnoreCase(name + "%") : null;
    }
}
