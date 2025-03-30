package com.example.assignment.order.domain;

import com.example.assignment.common.jpa.BaseEntity;
import com.example.assignment.common.jpa.CustomIdGenerator;
import com.example.assignment.common.enums.DeliveryStatusEnum;
import com.example.assignment.common.vo.Address;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "delivery")
@DynamicUpdate
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "delivery_id")
    private Long deliveryId;

    @Column(name = "order_id", nullable = false, updatable = false)
    private Long orderId;

    @Column(name = "name")
    private String receiverName;

    private String receiverPhone;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "delivery_status", length = 30)
    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum deliveryStatus;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Order order;

}
