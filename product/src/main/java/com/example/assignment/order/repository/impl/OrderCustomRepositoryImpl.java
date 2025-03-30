package com.example.assignment.order.repository.impl;

import com.example.assignment.order.domain.QDelivery;
import com.example.assignment.order.domain.QOrder;
import com.example.assignment.order.dto.OrderListDto;
import com.example.assignment.order.repository.OrderCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderCustomRepositoryImpl implements OrderCustomRepository {

    private final JPAQueryFactory queryFactory;

    final QOrder order = QOrder.order;
    final QDelivery delivery = QDelivery.delivery;

    @Override
    public List<OrderListDto.Response> findByConditions(OrderListDto.Request request, Pageable pageInfo) {
        return this.queryFactory
                .select(
                    Projections.constructor(
                        OrderListDto.Response.class,
                        order.orderId,
                        order.orderNumber,
                        order.description,
                        order.orderStatus,
                        delivery.receiverName,
                        delivery.zipcode,
                        delivery.address1,
                        delivery.address2,
                        delivery.deliveryStatus
                    )
                )
                .from(order)
                .leftJoin(delivery).on(order.orderId.eq(delivery.orderId))
                .limit(pageInfo.getPageSize())
                .offset(pageInfo.getOffset())
                .fetch();
    }

    @Override
    public Long countByConditions(OrderListDto.Request request) {
        return this.queryFactory.select(order.count())
                .from(order)
                .fetchOne();
    }

}
