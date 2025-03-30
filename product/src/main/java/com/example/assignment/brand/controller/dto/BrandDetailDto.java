package com.example.assignment.brand.controller.dto;

import com.example.assignment.brand.domain.Brand;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandDetailDto {
    public record Request(@NotNull Long brandId) {}
    @Builder
    public record Response(Long brandId, String name, String description, String homepageUrl){
        public static BrandDetailDto.Response fromEntity(Brand brand) {
            return BrandDetailDto.Response.builder()
                    .brandId(brand.getBrandId())
                    .description(brand.getDescription())
                    .homepageUrl(brand.getHomepageUrl())
                    .build();
        }
    }
}
