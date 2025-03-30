package com.example.assignment.products.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductItemAddDto {

    @Getter
    public class Request {
        @NotNull
        @Schema(name = "productId", description = "상품ID")
        private Long productId;
        @NotNull
        @Schema(name = "productDetailId", description = "상품상세ID")
        private Long productDetailId;
        @NotNull
        @Schema(name = "productId", description = "가격")
        private BigDecimal price;
        @NotNull
        @Schema(name = "stock", description = "재고")
        private Integer stock;
        @NotNull
        @Schema(name = "productOptionId", description = "상품옵션ID")
        private Long productOptionId;
        @NotNull
        @Schema(name = "optionValueId", description = "옵션값ID")
        private Long optionValueId;
        @Schema(name = "expireDate", description = "폐기일자")
        private LocalDate expireDate;
    }

    @Getter
    public class Response {
        private Long productItemId;
    }
}