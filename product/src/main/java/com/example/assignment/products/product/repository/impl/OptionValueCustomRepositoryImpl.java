package com.example.assignment.products.product.repository.impl;

import com.example.assignment.products.product.dto.OptionValueListDto;
import com.example.assignment.products.product.repository.OptionValueCustomRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OptionValueCustomRepositoryImpl implements OptionValueCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<OptionValueListDto.Response> findByConditions(OptionValueListDto.Request request, Pageable pageInfo) {
        return null;
    }

    @Override
    public Long countByConditions(OptionValueListDto.Request request) {
        return null;
    }
}
