package com.example.assignment.products.product.repository;

import com.example.assignment.products.domains.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOptionRepository extends JpaRepository<ProductOption, Long>, ProductOptionCustomRepository{
}
