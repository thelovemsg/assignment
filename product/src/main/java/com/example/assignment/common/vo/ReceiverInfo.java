package com.example.assignment.common.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReceiverInfo {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public ReceiverInfo changeReceiverInfo(String name, String phone) {
        return new ReceiverInfo(name, phone);
    }
}
