package com.example.assignment.common.jpa;

import com.github.f4b6a3.tsid.Tsid;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

@SuppressWarnings("deprecation")
public class JpaIdGenerator implements IdentifierGenerator {
    @Override
    public Long generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return Tsid.fast().toLong();
    }
}
