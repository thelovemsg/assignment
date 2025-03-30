package com.example.assignment.products.domains;

import com.example.assignment.common.vo.Money;
import com.example.assignment.products.domains.id.ProductItemId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 실제로 팔리는 단위를 가지고 있는 테이블
 * SKU(Stock Keeping Unit) 을 관리한다.
 */
@Getter
@Entity
@Table(name = "product_item")
@IdClass(ProductItemId.class)
@DynamicUpdate

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )

    @Column(name = "product_item_id")
    private Long productItemId;

    @Id
    @Column(name = "stock_keeping_unit_code")
    private String stockKeepingUnitCode;

    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" ,referencedColumnName = "product_id", insertable = false, updatable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;

    @Embedded
    @Column(name = "price")
    private Money price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "expire_date")
    private LocalDate expireDate;

}
