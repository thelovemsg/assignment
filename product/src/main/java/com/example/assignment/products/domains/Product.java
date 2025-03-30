package com.example.assignment.products.domains;

import com.example.assignment.brand.domain.Brand;
import com.example.assignment.common.jpa.BaseEntity;
import com.example.assignment.common.enums.ProductStatusEnum;
import com.example.assignment.common.vo.Money;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "product")
@DynamicUpdate
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Embedded
    private Money basePrice;

    @Column(name = "brand_id", nullable = false, updatable = false)
    private Long brandId;

    @Column(name = "product_status", length = 30)
    @Enumerated(EnumType.STRING)
    private ProductStatusEnum productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Brand brand;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @Builder.Default
    private List<ProductDetail> productDetails = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    @Builder.Default
    private List<ProductCategory> productCategories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    @Builder.Default
    private List<ProductOption> productOptions = new ArrayList<>();

    public ProductDetail getLatestDetail() {
        return this.productDetails.stream()
                .filter(ProductDetail::isLastDetail)
                .findFirst()
                .orElse(null);
    }

}
