package com.example.assignment.order.repository;

import com.example.assignment.order.dto.OrderListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderCustomRepository {
    List<OrderListDto.Response> findByConditions(OrderListDto.Request request, Pageable pageable);
    Long countByConditions(OrderListDto.Request request);
}
