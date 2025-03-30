package com.example.assignment.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryTypeEnum {
    CLOTHING,        // 의류
    FOOD,            // 식품
    ELECTRONICS,     // 전자기기
    BEAUTY,          // 뷰티/화장품
    BOOKS,           // 도서
    SPORTS,          // 스포츠/레저
    HOME,            // 가전/가구/인테리어
    BEDDING,         // 침구류
    TOYS,            // 완구/취미
    PETS,            // 반려동물용품
    HEALTH,          // 건강식품/의약외품
    OFFICE,          // 문구/사무용품
    ETC;              // 기타

}
