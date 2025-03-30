package com.example.assignment.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class Money {

    private BigDecimal price;

    @JsonCreator
    public Money(BigDecimal price) {
        this.price = price;
    }

    @JsonValue
    public BigDecimal getValue() {
        return price;
    }

    public Money subtract(BigDecimal minus) {
        BigDecimal result = this.price.subtract(minus);
        if (result.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("금액은 0보다 작을 수 없습니다.");
        }
        return new Money(result);
    }

    public Money plus(BigDecimal plus) {
        return new Money(this.price.add(plus));
    }

    public boolean isGreaterThan(Money other) {
        return this.price.compareTo(other.price) > 0;
    }

    public boolean isLessThan(Money other) {
        return this.price.compareTo(other.price) < 0;
    }

    public boolean isPositive() {
        return this.price.compareTo(BigDecimal.ZERO) > 0;
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }

    public static Money of(long value) {
        return new Money(BigDecimal.valueOf(value));
    }

    public static Money of(BigDecimal value) {
        return new Money(value);
    }
}
