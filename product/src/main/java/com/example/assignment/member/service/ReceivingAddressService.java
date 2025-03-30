package com.example.assignment.member.service;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.member.domain.ReceivingAddress;
import com.example.assignment.member.dto.ReceivingAddressDeleteDto;
import com.example.assignment.member.dto.ReceivingAddressDetailDto;
import com.example.assignment.member.dto.ReceivingAddressListDto;
import com.example.assignment.member.dto.ReceivingAddressSaveDto;
import com.example.assignment.member.repository.ReceivingAddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceivingAddressService {

    private final ReceivingAddressRepository receivingAddressRepository;

    public Page<ReceivingAddressListDto.Response> list(ReceivingAddressListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> receivingAddressRepository.findByConditions(request, pageInfo),
                () -> receivingAddressRepository.countByConditions(request));
    }

    public ReceivingAddressDetailDto.Response detail(ReceivingAddressDetailDto.Request request) {
        ReceivingAddress member = receivingAddressRepository.findById(request.receivingAddressId())
                        .orElseThrow(() -> new NotFoundException(MessageCode.MEMBER_NOT_FOUND, request.receivingAddressId()));
        return ReceivingAddressDetailDto.Response.fromEntity(member);
    }

    @Transactional
    public Long save(ReceivingAddressSaveDto.Request request) {
        if(request.isMainAddress()) {
            setPreviousDetailsToNotLast(request.memberId());
        }

        return receivingAddressRepository.save(request.toEntity()).getReceivingAddressId();
    }

    @Transactional
    public void delete(ReceivingAddressDeleteDto.Request request) {
        ReceivingAddress receivingAddress = receivingAddressRepository.findById(request.receivingAddressId())
                .orElseThrow(() -> new NotFoundException(MessageCode.RECEIVING_ADDRESS_NOT_FOUND, request.receivingAddressId()));

        receivingAddressRepository.delete(receivingAddress);
    }

    private void setPreviousDetailsToNotLast(Long memberId) {
        List<ReceivingAddress> addresses = receivingAddressRepository.findAllByMemberId(memberId);
        addresses.stream()
                .filter(ReceivingAddress::getIsMainAddress)
                .forEach(ReceivingAddress::settingAsNotMainAddress);
    }
}
