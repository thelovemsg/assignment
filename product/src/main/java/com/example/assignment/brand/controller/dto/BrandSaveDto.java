package com.example.assignment.brand.controller.dto;

import com.example.assignment.brand.domain.Brand;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandSaveDto {
    public record Request(Long brandId, String name, String description, String homepageUrl) {
        public static Brand toEntity(Request request) {
            return Brand.builder()
                    .brandId(request.brandId())
                    .name(request.name())
                    .homepageUrl(request.homepageUrl())
                    .description(request.description())
                    .build();
        }
    }

    @Builder
    public record Response(Long brandId) {
        public static Response fromEntity(Request request) {
            return Response.builder()
                    .brandId(request.brandId())
                    .build();
        }
    }
}
