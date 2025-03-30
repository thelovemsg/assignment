package com.example.assignment.products.product.dto;

import com.example.assignment.common.enums.LanguageCodeEnum;
import com.example.assignment.common.enums.ProductStatusEnum;
import com.example.assignment.common.vo.Money;
import com.example.assignment.products.domains.ProductDetail;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDetailSaveDto {
    public record Request(@NotNull Long productId, @NotNull LanguageCodeEnum languageCode,
                          @NotEmpty String version, @NotNull Money basePrice, @NotNull ProductStatusEnum productDetailStatus, Boolean isLastDetail) {
        public ProductDetail toEntity() {
            return ProductDetail.builder()
                    .productId(this.productId)
                    .languageCode(this.languageCode)
                    .version(this.version)
                    .basePrice(this.basePrice)
                    .productDetailStatus(this.productDetailStatus)
                    .isLastDetail(this.isLastDetail)
                    .build();
        }
    }
    public record Response(Long productId) {}
}