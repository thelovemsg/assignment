package com.example.assignment.products.domains;

import com.example.assignment.common.jpa.BaseEntity;
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
@Table(name = "product_option")
@DynamicUpdate

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOption extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "product_option_id")
    private Long productOptionId;

    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

    @Column(name = "code")
    private String code;

    @Column(name = "option_name")
    private String optionName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "is_required")
    @Builder.Default
    private Boolean isRequired = Boolean.FALSE;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", updatable = false, insertable = false
            , foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;

    @JsonIgnore
    @OneToMany(mappedBy = "productOption")
    @Builder.Default
    private List<OptionValue> optionValues = new ArrayList<>();

}
