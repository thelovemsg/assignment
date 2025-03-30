package com.example.assignment.member.service;

import com.example.assignment.common.exception.NotFoundException;
import com.example.assignment.common.message.MessageCode;
import com.example.assignment.common.utils.PaginationUtils;
import com.example.assignment.member.domain.Member;
import com.example.assignment.member.dto.MemberDeleteDto;
import com.example.assignment.member.dto.MemberDetailDto;
import com.example.assignment.member.dto.MemberListDto;
import com.example.assignment.member.dto.MemberSaveDto;
import com.example.assignment.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Page<MemberListDto.Response> list(MemberListDto.Request request, Pageable pageable) {
        return PaginationUtils.toPage(pageable,
                pageInfo -> memberRepository.findByConditions(request, pageInfo),
                () -> memberRepository.countByConditions(request));
    }

    public MemberDetailDto.Response detail(MemberDetailDto.Request request) {
        Member member = memberRepository.findById(request.memberId()).orElseThrow(() -> new NotFoundException(MessageCode.MEMBER_NOT_FOUND, request.memberId()));
        return MemberDetailDto.Response.fromEntity(member);
    }

    @Transactional
    public Long save(MemberSaveDto.Request request) {
        Member entity = request.toEntity();
        return memberRepository.save(entity).getMemberId();
    }

    @Transactional
    public void delete(MemberDeleteDto.Request request) {
        Member member = memberRepository.findById(request.memberId()).orElseThrow(() -> new NotFoundException(MessageCode.MEMBER_NOT_FOUND, request.memberId()));
        memberRepository.delete(member);
    }

}
