package com.example.assignment.category.repository;

import com.example.assignment.category.domain.QCategory;
import com.example.assignment.category.dto.CategoryListDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.internal.util.StringHelper.coalesce;

@Repository
@RequiredArgsConstructor
public class CategoryCustomRepositoryImpl implements CategoryCustomRepository {

    private final JPAQueryFactory queryFactory;

    final QCategory parent = new QCategory("category");
    final QCategory child = new QCategory("parent");

    @Override
    public List<CategoryListDto.Response> findByConditions(CategoryListDto.Request request, Pageable pageable) {
        return this.queryFactory
                    .select(Projections.constructor(
                            CategoryListDto.Response.class,
                            child.categoryId,
                            child.name,
                            parent.categoryId,
                            parent.name
                    )
                )
                .from(child)
                .leftJoin(child.parent, parent)
                .where(
                        eqParentId(request.parentId()))
                .orderBy(
                        parent.categoryId.coalesce(child.categoryId).asc(),   // 그룹 묶기
                        parent.name.coalesce(child.name).asc(),               // 그룹 정렬
                        child.name.asc()
                )
                .fetch();
    }

    @Override
    public Long countByConditions(CategoryListDto.Request request) {
        return this.queryFactory
                .select(parent.count())
                .from(child)
                .leftJoin(child.parent, parent)
                .where(
                        eqParentId(request.parentId()))
                .fetchOne();
    }

    @Override
    public boolean existsByParentCategoryId(Long categoryId) {
        return queryFactory
                .selectOne()
                .from(parent)
                .where(parent.parent.categoryId.eq(categoryId))
                .fetchFirst() != null;
    }

    public BooleanExpression eqParentId(Long parentId) {
        return ObjectUtils.isNotEmpty(parentId) ? parent.parent.categoryId.eq(parentId) : null;
    }
}
