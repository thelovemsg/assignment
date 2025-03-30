package com.example.assignment.order.dto;

import com.example.assignment.order.domain.Order;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDetailDto {
    public record Request(@NotNull Long orderId) {}
    @Builder
    public record Response() {
        public static Response fromEntity(Order order) {
            return null;
        }
    }
}
