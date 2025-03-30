package com.example.assignment.member.domain;

import com.example.assignment.common.jpa.BaseEntity;
import com.example.assignment.common.jpa.CustomIdGenerator;
import com.example.assignment.common.vo.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Table(name = "receiving_address")
@DynamicUpdate

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceivingAddress extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "receiving_address_id")
    private Long receivingAddressId;

    @Column(name = "member_id", nullable = false, updatable = false)
    private Long memberId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "is_main_address")
    @Builder.Default
    private Boolean isMainAddress = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member member;

    public void settingAsNotMainAddress() {
        this.isMainAddress = Boolean.FALSE;
    }
}
