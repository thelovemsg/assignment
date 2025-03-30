package com.example.assignment.member.repository.impl;

import com.example.assignment.member.domain.QMember;
import com.example.assignment.member.dto.MemberListDto;
import com.example.assignment.member.repository.MemberCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberCustomRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory queryFactory;

    final QMember member = QMember.member;

    @Override
    public List<MemberListDto.Response> findByConditions(MemberListDto.Request request, Pageable pageable) {
        return this.queryFactory
                .select(
                        Projections.constructor(
                                MemberListDto.Response.class,
                                member.memberId,
                                member.email,
                                member.name,
                                member.phone
                        )
                )
                .from(member)
                .where(
                        //TODO : 검색 조건 세팅
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countByConditions(MemberListDto.Request request) {
        return this.queryFactory
                .select(
                       member.count()
                )
                .from(member)
                .where(
                        //TODO : 검색 조건 세팅
                )
                .fetchOne();
    }
}
