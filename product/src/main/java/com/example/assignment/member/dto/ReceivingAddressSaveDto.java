package com.example.assignment.member.dto;

import com.example.assignment.member.domain.ReceivingAddress;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceivingAddressSaveDto {
    public record Request(Long receivingAddressId, @NotNull Long memberId, @NotBlank String phone, @NotBlank @Email String email,
                          @NotBlank String zipcode, @NotBlank String address1, @NotBlank String address2, @NotNull Boolean isMainAddress) {
        public ReceivingAddress toEntity() {
            return ReceivingAddress.builder()
                    .receivingAddressId(this.receivingAddressId)
                    .memberId(this.memberId)
                    .phone(this.phone)
                    .email(this.email)
                    .zipcode(this.zipcode)
                    .address1(this.address1)
                    .address2(this.address2)
                    .isMainAddress(this.isMainAddress)
                    .build();
        }
    }
    public record Response(Long receivingAddressId) {}
}