package com.example.assignment.member.dto;

import com.example.assignment.member.domain.Member;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDetailDto {
    public record Request(@NotNull Long memberId) {}
    @Builder
    public record Response(Long memberId, String email, String name, String phone) {
        public static Response fromEntity(Member member) {
            return Response.builder()
                    .memberId(member.getMemberId())
                    .email(member.getEmail())
                    .name(member.getName())
                    .phone(member.getPhone())
                    .build();
        }
    }
}