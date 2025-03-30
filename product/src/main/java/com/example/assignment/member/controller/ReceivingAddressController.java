package com.example.assignment.ReceivingAddress.controller;

import com.example.assignment.member.dto.ReceivingAddressDeleteDto;
import com.example.assignment.member.dto.ReceivingAddressDetailDto;
import com.example.assignment.member.dto.ReceivingAddressListDto;
import com.example.assignment.member.dto.ReceivingAddressSaveDto;
import com.example.assignment.member.service.ReceivingAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/receiving-address")
@RequiredArgsConstructor
public class ReceivingAddressController {

    private final ReceivingAddressService addressService;

    @PostMapping("/list")
    public ResponseEntity<Page<ReceivingAddressListDto.Response>> getProducts(@RequestBody @Valid ReceivingAddressListDto.Request request, Pageable pageable) {
        Page<ReceivingAddressListDto.Response> categories = addressService.list(request, pageable);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/detail")
    public ResponseEntity<ReceivingAddressDetailDto.Response> detail(@Valid @RequestBody ReceivingAddressDetailDto.Request request) {
        return ResponseEntity.ok(addressService.detail(request));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody ReceivingAddressSaveDto.Request request) {
        return ResponseEntity.ok(addressService.save(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody ReceivingAddressDeleteDto.Request request) {
        addressService.delete(request);
    }
}
