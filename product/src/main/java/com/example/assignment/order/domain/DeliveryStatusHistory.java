package com.example.assignment.order.domain;

import com.example.assignment.common.jpa.BaseEntity;
import com.example.assignment.common.enums.DeliveryStatusEnum;
import com.example.assignment.common.jpa.CustomIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_status_history")
@DynamicUpdate
public class DeliveryStatusHistory extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "delivery_status_history_id")
    private Long deliveryStatusHistoryId;

    @Column(name = "delivery_id")
    private Long deliveryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private DeliveryStatusEnum status;

    @CreatedDate
    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;

    @Column(name = "changed_by")
    private String changedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Delivery delivery;
}
