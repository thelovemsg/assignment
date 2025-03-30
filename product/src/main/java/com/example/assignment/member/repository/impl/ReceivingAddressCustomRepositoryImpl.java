package com.example.assignment.member.repository.impl;

import com.example.assignment.member.domain.QReceivingAddress;
import com.example.assignment.member.dto.ReceivingAddressListDto;
import com.example.assignment.member.repository.ReceivingAddressCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReceivingAddressCustomRepositoryImpl implements ReceivingAddressCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    final QReceivingAddress receivingAddress = QReceivingAddress.receivingAddress;

    @Override
    public List<ReceivingAddressListDto.Response> findByConditions(ReceivingAddressListDto.Request request, Pageable pageInfo) {
        return this.jpaQueryFactory.select(
                    Projections.constructor(
                        ReceivingAddressListDto.Response.class,
                            receivingAddress.receivingAddressId,
                            receivingAddress.phone,
                            receivingAddress.email,
                            receivingAddress.zipcode,
                            receivingAddress.address1,
                            receivingAddress.address2,
                            receivingAddress.isMainAddress
                    )
                )
                .from(receivingAddress)
                .where()
                .offset(pageInfo.getOffset())
                .limit(pageInfo.getPageSize())
                .fetch();
    }

    @Override
    public Long countByConditions(ReceivingAddressListDto.Request request) {
        return this.jpaQueryFactory.select(
                    receivingAddress.count()
                )
                .from(receivingAddress)
                .where()
                .fetchOne();
    }
}
