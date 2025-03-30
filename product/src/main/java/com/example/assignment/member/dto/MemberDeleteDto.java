package com.example.assignment.member.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDeleteDto {
    public record Request(Long memberId) {}
    public record Response() {}
}
