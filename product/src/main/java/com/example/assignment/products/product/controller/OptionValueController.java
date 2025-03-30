package com.example.assignment.products.product.controller;

import com.example.assignment.products.product.dto.OptionValueDeleteDto;
import com.example.assignment.products.product.dto.OptionValueListDto;
import com.example.assignment.products.product.service.OptionValueService;
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
@RequestMapping("/api/option-value")
@RequiredArgsConstructor
public class OptionValueController {

    private final OptionValueService optionValueService;

    @PostMapping("/list")
    public ResponseEntity<Page<OptionValueListDto.Response>> list(@Valid @RequestBody OptionValueListDto.Request request, Pageable pageable) {
        return ResponseEntity.ok(optionValueService.list(request, pageable));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> list(@Valid @RequestBody OptionValueListDto.Request request) {
        return ResponseEntity.ok(optionValueService.save(request));
    }

    @PostMapping("/delete")
    public void list(@Valid @RequestBody OptionValueDeleteDto.Request request) {
        optionValueService.delete(request);
    }
}
