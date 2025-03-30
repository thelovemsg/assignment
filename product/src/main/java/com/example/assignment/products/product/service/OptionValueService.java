package com.example.assignment.products.product.service;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.products.product.dto.OptionValueDeleteDto;
import com.example.assignment.products.product.dto.OptionValueListDto;
import com.example.assignment.products.product.repository.OptionValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptionValueService {

    private final OptionValueRepository optionValueRepository;

    public Page<OptionValueListDto.Response> list(OptionValueListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> optionValueRepository.findByConditions(request, pageInfo),
                () -> optionValueRepository.countByConditions(request));
    }

    public Long save(OptionValueListDto.Request request) {
        return optionValueRepository.save(request.toEntity()).getOptionValueId();
    }

    public void delete(OptionValueDeleteDto.Request request) {
        optionValueRepository.findById(request.optionValueId())
                .orElseThrow(() -> new NotFoundException(MessageCode.PRODUCT_OPTION_VALUE_NOT_FOUND, request.optionValueId()));
    }
}
