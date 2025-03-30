package com.example.assignment.order.service;

import com.example.assignment.order.dto.OrderSaveDto;
import com.example.assignment.order.repository.OrderRepository;
import com.example.assignment.products.product.repository.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderManager {

    private final OrderRepository orderRepository;
    private final ProductItemRepository productItemRepository;

    public Long orderProduct(OrderSaveDto.Request request) {
        return null;
    }

}
