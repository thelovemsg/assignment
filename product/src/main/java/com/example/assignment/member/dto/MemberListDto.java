package com.example.assignment.member.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberListDto {
    public record Request() {}
    public record Response(Long memberId, String email, String name, String phone) {}
}