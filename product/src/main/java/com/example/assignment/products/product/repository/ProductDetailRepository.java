package com.example.assignment.products.product.repository;

import com.example.assignment.products.domains.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>, ProductDetailCustomRepository {
    List<ProductDetail> findAllByProductId(Long productId);
}
