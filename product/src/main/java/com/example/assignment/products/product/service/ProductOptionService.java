package com.example.assignment.products.product.service;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.products.domains.ProductOption;
import com.example.assignment.products.product.dto.ProductOptionDeleteDto;
import com.example.assignment.products.product.dto.ProductOptionDetailDto;
import com.example.assignment.products.product.dto.ProductOptionListDto;
import com.example.assignment.products.product.dto.ProductOptionSaveDto;
import com.example.assignment.products.product.repository.ProductOptionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductOptionService {

    private final ProductOptionRepository productOptionRepository;

    public Page<ProductOptionListDto.Response> list(ProductOptionListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> productOptionRepository.findByConditions(request, pageInfo),
                () -> productOptionRepository.countByConditions(request));
    }

    public ProductOptionDetailDto.Response detail(ProductOptionDetailDto.Request request) {
        Long productOptionId = request.productOptionId();
        ProductOption productOption = productOptionRepository.findById(productOptionId).orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_OPTION_NOT_FOUND, productOptionId));
        return ProductOptionDetailDto.Response.fromEntity(productOption);
    }

    @Transactional
    public Long save(ProductOptionSaveDto.Request request) {
        return productOptionRepository.save(request.toEntity()).getProductOptionId();
    }

    @Transactional
    public void delete(ProductOptionDeleteDto.Request request) {
        Long productOptionId = request.productOptionId();
        ProductOption productOption = productOptionRepository.findById(productOptionId).orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_OPTION_NOT_FOUND, productOptionId));
        productOptionRepository.delete(productOption);
    }
}
