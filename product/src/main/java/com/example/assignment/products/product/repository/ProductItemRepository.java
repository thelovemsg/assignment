package com.example.assignment.products.product.repository;

import com.example.assignment.products.domains.ProductItem;
import com.example.assignment.products.domains.id.ProductItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, ProductItemId>, ProductItemCustomRepository {
}
