package com.example.assignment.products.domains;

import com.example.assignment.common.enums.LanguageCodeEnum;
import com.example.assignment.common.enums.ProductStatusEnum;
import com.example.assignment.common.jpa.BaseEntity;
import com.example.assignment.common.vo.Money;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * ProductDetail 은 Product에 종속된 Entity
 */
@Getter
@Entity
@Table(name = "product_detail")
@DynamicUpdate

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "product_detail_id")
    private Long productDetailId;

    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

    @Column(name = "description")
    private String description;

    @Column(name = "language_code", length = 20)
    @Enumerated(EnumType.STRING)
    private LanguageCodeEnum languageCode;

    @Column(name = "version")
    private String version;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "base_price")
    @Embedded
    private Money basePrice;

    @Column(name = "product_status", length = 20)
    @Enumerated(EnumType.STRING)
    private ProductStatusEnum productDetailStatus;

    @Column(name = "is_last_detail")
    @Builder.Default
    private Boolean isLastDetail = Boolean.TRUE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;

    public boolean isLastDetail() {
        return this.isLastDetail;
    }

    public void settingLastDetailToFalse() {
        this.isLastDetail = Boolean.FALSE;
    }
}