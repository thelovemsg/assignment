package com.example.assignment.member.repository;

import com.example.assignment.member.dto.MemberListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberCustomRepository {
    List<MemberListDto.Response> findByConditions(MemberListDto.Request request, Pageable pageable);
    Long countByConditions(MemberListDto.Request request);
}

