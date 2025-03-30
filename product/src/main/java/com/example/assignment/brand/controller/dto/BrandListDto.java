package com.example.assignment.brand.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "브랜드 List Dto")
public class BrandListDto {

    public record Request(@Schema(description = "브랜드명") String name) {}
    public record Response(
            @Schema(description = "브랜드ID")
            Long brandId,
            @Schema(description = "브랜드 이름")
            String name,
            @Schema(description = "브랜드 설명")
            String description,
            @Schema(description = "홈페이지 URL")
            String homepageUrl){}
}
