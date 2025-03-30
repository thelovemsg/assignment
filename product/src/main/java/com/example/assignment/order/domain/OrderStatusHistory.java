package com.example.assignment.order.domain;

import com.example.assignment.common.enums.OrderStatusEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_status_history")
public class OrderStatusHistory {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "order_status_history_id")
    private Long orderStatusHistoryId;

    @Column(name = "order_id")
    private Long orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatusEnum status;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;

    @Column(name = "changed_by")
    private String changedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Order order;
}