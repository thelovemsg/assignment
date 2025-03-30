package com.example.assignment.order.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDeleteDto {
    public record Request(Long orderId) {}
    public record Response() {}
}
