package com.example.assignment.products.product.dto;

import com.example.assignment.products.domains.ProductOption;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductOptionSaveDto {
    public record Request(@NotNull Long productId, Long productOptionId, @NotBlank String optionName,
                          @NotBlank String code, @NotBlank String displayName, @NotNull Integer sortOrder, Boolean isRequired) {
        public ProductOption toEntity() {
            return ProductOption
                    .builder()
                    .productId(this.productId)
                    .code(this.code)
                    .productOptionId(this.productOptionId)
                    .optionName(this.optionName)
                    .displayName(this.displayName)
                    .sortOrder(this.sortOrder)
                    .isRequired(this.isRequired)
                    .build();
        }
    }
    public record Response(Long productOptionId) {}
}
