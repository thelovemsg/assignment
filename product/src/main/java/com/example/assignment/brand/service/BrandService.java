package com.example.assignment.brand.service;

import com.example.assignment.brand.controller.dto.BrandDeleteDto;
import com.example.assignment.brand.controller.dto.BrandDetailDto;
import com.example.assignment.brand.controller.dto.BrandListDto;
import com.example.assignment.brand.controller.dto.BrandSaveDto;
import com.example.assignment.brand.domain.Brand;
import com.example.assignment.brand.repository.BrandRepository;
import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public Page<BrandListDto.Response> list(BrandListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                info -> brandRepository.findByConditions(request, info),
                () -> brandRepository.countByConditions(request));
    }

    public BrandDetailDto.Response detail(BrandDetailDto.Request request) {
        Brand brand = brandRepository.findById(request.brandId()).orElseThrow(() -> new NotFoundException(MessageCode.BRAND_NOT_FOUND, request.brandId()));
        return BrandDetailDto.Response.fromEntity(brand);
    }

    @Transactional
    public Long save(BrandSaveDto.Request request) {
        Brand save = brandRepository.save(request.toEntity(request));
        return save.getBrandId();
    }

    @Transactional
    public void delete(BrandDeleteDto.Request request) {
        if (!brandRepository.existsById(request.brandId())) {
            throw new NotFoundException(MessageCode.BRAND_NOT_FOUND, request.brandId());
        }
        brandRepository.deleteById(request.brandId());
    }
}
