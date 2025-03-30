package com.example.assignment.products.domains;

import com.example.assignment.common.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Table(name = "option_value")
@DynamicUpdate

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionValue extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "option_value_id")
    private Long optionValueId;

    @Column(name = "product_option_id")
    private Long productOptionId;

    @Column(name = "code")
    private String code;

    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", referencedColumnName = "product_option_id", updatable = false, insertable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ProductOption productOption;

}
