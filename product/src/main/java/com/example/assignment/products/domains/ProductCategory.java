package com.example.assignment.products.domains;

import com.example.assignment.category.domain.Category;
import com.example.assignment.common.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Table(name = "product_category")
@DynamicUpdate
public class ProductCategory extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Category category;

    @Column(name = "sort_order")
    private Integer sortOrder;

    private Boolean isMainCategory = Boolean.TRUE;

}
