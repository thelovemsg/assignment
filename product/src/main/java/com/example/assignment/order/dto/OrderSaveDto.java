package com.example.assignment.order.dto;

import com.example.assignment.products.product.dto.ProductItemListDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderSaveDto {
    public record Request(List<ProductItemListDto.Request> productItemList, Long memberId) {}
    public record Response() {}
}
