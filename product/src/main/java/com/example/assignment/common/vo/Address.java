package com.example.assignment.common.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;

    public static Address of(String zipcode, String address1, String address2) {
        return new Address(zipcode, address1, address2);
    }
}
