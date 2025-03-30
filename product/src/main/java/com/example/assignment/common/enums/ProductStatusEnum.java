package com.example.assignment.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatusEnum {
    SETTING, SELLING, SOLD_OUT, HIDDEN;
}

