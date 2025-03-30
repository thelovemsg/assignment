package com.example.assignment.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatusEnum {
    PREPARING,
    DELIVERING,
    ARRIVED,
    CANCELLED;
}
