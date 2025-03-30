package com.example.assignment.brand.controller;

import com.example.assignment.brand.controller.dto.BrandDeleteDto;
import com.example.assignment.brand.controller.dto.BrandDetailDto;
import com.example.assignment.brand.controller.dto.BrandListDto;
import com.example.assignment.brand.controller.dto.BrandSaveDto;
import com.example.assignment.brand.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "브랜드 관리 API", description = "브랜드 관리 API입니다.")
@RestController
@RequestMapping("/api/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "브랜드 조회", description = "브랜드 목록을 조회합니다.")
    @PostMapping("/list")
    public ResponseEntity<Page<BrandListDto.Response>> list(@RequestBody BrandListDto.Request request, Pageable pageable) {
        Page<BrandListDto.Response> brands = brandService.list(request, pageable);
        return ResponseEntity.ok(brands);
    }

    @Operation(summary = "브랜드 상세조회", description = "브랜드 상세 정보를 조회합니다.")
    @PostMapping("/detail")
    public ResponseEntity<BrandDetailDto.Response> detail(@Valid @RequestBody BrandDetailDto.Request request) {
        return ResponseEntity.ok(brandService.detail(request));
    }

    @Operation(summary = "브랜드 저장", description = "브랜드 정보를 저장한다.")
    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody BrandSaveDto.Request request) {
        return ResponseEntity.ok(brandService.save(request));
    }

    @Operation(summary = "브랜드 삭제", description = "브랜드 정보를 삭제한다.")
    @PostMapping("/delete")
    public void delete(@Valid @RequestBody BrandDeleteDto.Request request) {
        brandService.delete(request);
    }

}
