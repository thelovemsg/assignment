package com.example.assignment.order.service;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.order.domain.Order;
import com.example.assignment.order.dto.OrderDeleteDto;
import com.example.assignment.order.dto.OrderDetailDto;
import com.example.assignment.order.dto.OrderListDto;
import com.example.assignment.order.dto.OrderSaveDto;
import com.example.assignment.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Page<OrderListDto.Response> list(OrderListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> orderRepository.findByConditions(request, pageInfo),
                () -> orderRepository.countByConditions(request));
    }

    public OrderDetailDto.Response detail(OrderDetailDto.Request request) {
        Order order = orderRepository.findById(request.orderId()).orElseThrow(() -> new NotFoundException(MessageCode.ORDER_NOT_FOUND, request.orderId()));
        return OrderDetailDto.Response.fromEntity(order);

    }

    public void delete(OrderDeleteDto.Request request) {

    }
}
