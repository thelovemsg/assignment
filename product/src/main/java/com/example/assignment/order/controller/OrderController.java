package com.example.assignment.order.controller;

import com.example.assignment.order.dto.OrderDeleteDto;
import com.example.assignment.order.dto.OrderDetailDto;
import com.example.assignment.order.dto.OrderListDto;
import com.example.assignment.order.dto.OrderSaveDto;
import com.example.assignment.order.service.OrderManager;
import com.example.assignment.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderManager orderManager;

    @PostMapping("/list")
    public ResponseEntity<Page<OrderListDto.Response>> getProducts(@RequestBody @Valid OrderListDto.Request request, Pageable pageable) {
        Page<OrderListDto.Response> orders = orderService.list(request, pageable);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/detail")
    public ResponseEntity<OrderDetailDto.Response> detail(@Valid @RequestBody OrderDetailDto.Request request) {
        return ResponseEntity.ok(orderService.detail(request));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody OrderSaveDto.Request request) {
        return ResponseEntity.ok(orderManager.orderProduct(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody OrderDeleteDto.Request request) {
        orderService.delete(request);
    }
}
