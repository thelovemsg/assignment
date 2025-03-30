package com.example.assignment.brand.repository;

import com.example.assignment.brand.controller.dto.BrandListDto;
import com.example.assignment.brand.domain.Brand;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandCustomRepository {
    List<BrandListDto.Response> findByConditions(BrandListDto.Request request, Pageable pageable);
    Long countByConditions(BrandListDto.Request request);
}
