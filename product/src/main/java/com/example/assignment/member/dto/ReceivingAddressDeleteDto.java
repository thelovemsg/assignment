package com.example.assignment.member.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReceivingAddressDeleteDto {
    public record Request(@NotNull Long receivingAddressId) {}
    public record Response() {}
}
