package com.example.assignment.common.message;

import java.text.MessageFormat;

public enum MessageCode {

    //회원
    MEMBER_NOT_FOUND("회원이 존재하지 않습니다. [id: {0}]"),

    //주소
    RECEIVING_ADDRESS_NOT_FOUND("수령주소정보가 존재하지 않습니다. [id: {0}]"),

    //브랜드
    BRAND_NOT_FOUND("브랜드가 존재하지 않습니다. [id: {0}]"),

    //상품
    PRODUCT_NOT_FOUND("상품이 존재하지 않습니다. [id: {0}]"),
    PRODUCT_DETAIL_NOT_FOUND("상품 상세가 존재하지 않습니다. [id: {0}]"),
    PRODUCT_OPTION_NOT_FOUND("상품 옵션이 존재하지 않습니다. [id: {0}]"),
    PRODUCT_OPTION_VALUE_NOT_FOUND("상품 옵션 값이 존재하지 않습니다. [id: {0}]"),

    //카테고리
    CATEGORY_NOT_FOUND("카테고리가 존재하지 않습니다. [id: {0}]"),
    CATEGORY_PARENT_NOT_FOUND("부모 카테고리가 존재하지 않습니다. [id: {0}]"),
    CATEGORY_CHILD_EXISTS("하위 카테고리가 존재합니다. [id: {0}]"),

    //주문
    ORDER_NOT_FOUND("주문이 존재하지 않습니다. [id: {0}]"),

    //내부
    INTERNAL_SERVER_ERROR("서버 오류가 발생했습니다.");

    private final String messageTemplate;

    MessageCode(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String format(Object... args) {
        return MessageFormat.format(messageTemplate, args);
    }
}
