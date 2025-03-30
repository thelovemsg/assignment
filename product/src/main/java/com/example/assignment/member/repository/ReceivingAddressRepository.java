package com.example.assignment.member.repository;

import com.example.assignment.member.domain.ReceivingAddress;
import com.example.assignment.products.domains.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceivingAddressRepository extends JpaRepository<ReceivingAddress, Long>, ReceivingAddressCustomRepository {
    List<ReceivingAddress> findAllByMemberId(Long memberId);
}
