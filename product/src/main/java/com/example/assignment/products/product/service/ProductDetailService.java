package com.example.assignment.products.product.service;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.products.domains.ProductDetail;
import com.example.assignment.products.product.dto.ProductDetailDeleteDto;
import com.example.assignment.products.product.dto.ProductDetailDetailDto;
import com.example.assignment.products.product.dto.ProductDetailListDto;
import com.example.assignment.products.product.dto.ProductDetailSaveDto;
import com.example.assignment.products.product.repository.ProductDetailRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.annotations.NotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    public Page<ProductDetailListDto.Response> list(ProductDetailListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> productDetailRepository.findByConditions(request, pageInfo),
                () -> productDetailRepository.countByConditions(request));
    }

    public ProductDetailDetailDto.Response detail(ProductDetailDetailDto.Request request) {
        ProductDetail productDetail = productDetailRepository.findById(request.productDetailId())
                .orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_DETAIL_NOT_FOUND, request.productDetailId()));
        return ProductDetailDetailDto.Response.fromEntity(productDetail);
    }

    @Transactional
    public Long save(ProductDetailSaveDto.Request request) {
        if (request.isLastDetail()) {
            setPreviousDetailsToNotLast(request.productId());
        }

        return productDetailRepository.save(request.toEntity()).getProductId();
    }

    @Transactional
    public void delete(ProductDetailDeleteDto.Request request) {
        productDetailRepository.findById(request.productDetailId())
                .orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_DETAIL_NOT_FOUND, request.productDetailId()));
        productDetailRepository.deleteById(request.productDetailId());
    }

    private void setPreviousDetailsToNotLast(Long productId) {
        List<ProductDetail> details = productDetailRepository.findAllByProductId(productId);
        details.stream()
                .filter(ProductDetail::isLastDetail)
                .forEach(ProductDetail::settingLastDetailToFalse);
    }
}
