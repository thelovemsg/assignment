package com.example.assignment.member.dto;

import com.example.assignment.member.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberSaveDto {
    public record Request(Long memberId, @NotBlank @Email String email, @NotBlank String name, @NotBlank String phone) {
        public Member toEntity() {
            return Member.builder()
                    .memberId(memberId)
                    .email(email)
                    .name(name)
                    .phone(phone)
                    .build();
        }
    }
    public record Response() {}
}