package com.example.assignment.products.product.service;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.products.domains.Product;
import com.example.assignment.products.product.dto.ProductDeleteDto;
import com.example.assignment.products.product.dto.ProductDetailDto;
import com.example.assignment.products.product.dto.ProductListDto;
import com.example.assignment.products.product.dto.ProductSaveDto;
import com.example.assignment.products.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductListDto.Response> list(ProductListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> productRepository.findByConditions(request, pageInfo),
                () -> productRepository.countByConditions(request));
    }

    public ProductDetailDto.Response detail(ProductDetailDto.Request request) {
        Product product = productRepository.findById(request.productId()).orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_NOT_FOUND, request.productId()));
        return ProductDetailDto.Response.fromEntity(product);
    }

    public Long save(ProductSaveDto.Request request) {
        return productRepository.save(request.toEntity()).getProductId();
    }

    public void delete(ProductDeleteDto.Request request) {
        Product product = productRepository.findById(request.productId()).orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_NOT_FOUND, request.productId()));
        productRepository.delete(product);
    }

}
