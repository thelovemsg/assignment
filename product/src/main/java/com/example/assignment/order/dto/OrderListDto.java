package com.example.assignment.order.dto;

import com.example.assignment.common.enums.DeliveryStatusEnum;
import com.example.assignment.common.enums.OrderStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderListDto {
    public record Request(@NotNull Long memberId, String orderNumber) {}
    public record Response(
            Long orderId,
            String orderNumber,
            String description,
            OrderStatusEnum orderStatus,
            String receiverName,
            String zipcode,
            String address1,
            String address2,
            DeliveryStatusEnum deliveryStatus
    ) {}
}