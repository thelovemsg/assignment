package com.example.assignment.products.product.repository;

import com.example.assignment.products.domains.OptionValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionValueRepository extends JpaRepository<OptionValue, Long>, OptionValueCustomRepository {
}
