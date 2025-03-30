package com.example.assignment.brand.repository;

import com.example.assignment.brand.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long>, BrandCustomRepository {
}
