package com.example.assignment.products.product.dto;

import com.example.assignment.common.enums.LanguageCodeEnum;
import com.example.assignment.common.enums.ProductStatusEnum;
import com.example.assignment.common.vo.Money;
import com.example.assignment.products.domains.ProductDetail;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDetailDetailDto {
    public record Request(@NotNull Long productDetailId) {}

    @Builder
    public record Response(String version, Money basePrice, LanguageCodeEnum languageCode
                        , ProductStatusEnum productDetailStatus, Boolean isLastDetail) {
        public static Response fromEntity(ProductDetail productDetail) {
            return Response.builder()
                    .version(productDetail.getVersion())
                    .basePrice(productDetail.getBasePrice())
                    .languageCode(productDetail.getLanguageCode())
                    .productDetailStatus(productDetail.getProductDetailStatus())
                    .isLastDetail(productDetail.getIsLastDetail())
                    .build();
        }
    }
}


