package com.example.assignment.products.product.dto;

import com.example.assignment.products.domains.OptionValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionValueListDto {
    @Builder
    public record Request(@NotNull Long productOptionId, Long optionValueId, @NotBlank String value, @NotBlank String displayName,
                          @NotBlank String description, Integer sortOrder) {
        public OptionValue toEntity() {
            return OptionValue.builder()
                    .productOptionId(this.productOptionId)
                    .optionValueId(this.optionValueId)
                    .value(this.value)
                    .displayName(this.displayName)
                    .description(this.description)
                    .sortOrder(this.sortOrder)
                    .build();
        }
    }
    public record Response() {}
}
