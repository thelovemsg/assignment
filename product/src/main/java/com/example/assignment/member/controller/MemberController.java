package com.example.assignment.member.controller;

import com.example.assignment.member.dto.MemberDeleteDto;
import com.example.assignment.member.dto.MemberDetailDto;
import com.example.assignment.member.dto.MemberListDto;
import com.example.assignment.member.dto.MemberSaveDto;
import com.example.assignment.member.service.MemberService;
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
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/list")
    public ResponseEntity<Page<MemberListDto.Response>> getProducts(@RequestBody MemberListDto.Request request, Pageable pageable) {
        Page<MemberListDto.Response> categories = memberService.list(request, pageable);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/detail")
    public ResponseEntity<MemberDetailDto.Response> detail(@Valid @RequestBody MemberDetailDto.Request request) {
        return ResponseEntity.ok(memberService.detail(request));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody MemberSaveDto.Request request) {
        return ResponseEntity.ok(memberService.save(request));
    }

    @PostMapping("/delete")
    public void delete(@Valid @RequestBody MemberDeleteDto.Request request) {
        memberService.delete(request);
    }
}
