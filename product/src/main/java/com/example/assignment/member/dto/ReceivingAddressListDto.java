package com.example.assignment.member.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceivingAddressListDto {
    public record Request(@NotNull Long memberId) {}
    public record Response(Long receivingAddressId, String phone, String email,
                           String zipcode, String address1, String address2,Boolean isMainAddress) {}
}