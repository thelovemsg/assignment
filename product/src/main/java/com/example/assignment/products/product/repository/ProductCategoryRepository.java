package com.example.assignment.products.product.repository;

import com.example.assignment.products.domains.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>, ProductCategoryCustomRepository {
}
