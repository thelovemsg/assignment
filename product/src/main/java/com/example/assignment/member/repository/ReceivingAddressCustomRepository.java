package com.example.assignment.member.repository;

import com.example.assignment.member.dto.ReceivingAddressListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceivingAddressCustomRepository {
    List<ReceivingAddressListDto.Response> findByConditions(ReceivingAddressListDto.Request request, Pageable pageInfo);
    Long countByConditions(ReceivingAddressListDto.Request request);
}
