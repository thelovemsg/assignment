package com.example.assignment.products.product.repository;

import com.example.assignment.products.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCustomRepository {
}
