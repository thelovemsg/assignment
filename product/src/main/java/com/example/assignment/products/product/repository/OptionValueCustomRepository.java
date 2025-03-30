package com.example.assignment.products.product.repository;

import com.example.assignment.products.product.dto.OptionValueListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OptionValueCustomRepository {
    List<OptionValueListDto.Response> findByConditions(OptionValueListDto.Request request, Pageable pageInfo);
    Long countByConditions(OptionValueListDto.Request request);
}
