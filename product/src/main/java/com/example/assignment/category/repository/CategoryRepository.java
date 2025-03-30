package com.example.assignment.category.repository;

import com.example.assignment.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryCustomRepository {
}
