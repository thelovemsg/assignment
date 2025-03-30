package com.example.assignment.order.repository;

import com.example.assignment.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderCustomRepository {
}
