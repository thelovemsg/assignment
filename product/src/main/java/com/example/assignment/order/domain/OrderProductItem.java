package com.example.assignment.order.domain;

import com.example.assignment.common.vo.Money;
import com.example.assignment.products.domains.ProductItem;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_product_item")
@DynamicUpdate
public class OrderProductItem {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "order_product_item_id")
    private Long orderProductItemId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_item_id")
    private Long productItemId;

    private Long quantity;

    private Money price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", updatable = false, insertable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_item_id", referencedColumnName = "product_item_id", updatable = false, insertable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ProductItem productItem;
}
