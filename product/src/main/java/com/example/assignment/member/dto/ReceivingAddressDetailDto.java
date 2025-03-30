package com.example.assignment.member.dto;

import com.example.assignment.member.domain.ReceivingAddress;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceivingAddressDetailDto {
    public record Request(Long receivingAddressId) {}
    @Builder
    public record Response(
            Long receivingAddressId, Long memberId, String phone, String email,
            String zipcode, String address1, String address2, Boolean isMainAddress) {
        public static Response fromEntity(ReceivingAddress member) {
            return Response.builder()
                    .receivingAddressId(member.getReceivingAddressId())
                    .memberId(member.getMemberId())
                    .phone(member.getPhone())
                    .email(member.getEmail())
                    .zipcode(member.getZipcode())
                    .address1(member.getAddress1())
                    .address2(member.getAddress2())
                    .isMainAddress(member.getIsMainAddress())
                    .build();
        }
    }
}