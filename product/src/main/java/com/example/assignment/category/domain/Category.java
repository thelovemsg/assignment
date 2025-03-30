package com.example.assignment.category.domain;

import com.example.assignment.common.jpa.BaseEntity;
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
@Table(name = "category")
@DynamicUpdate
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id",  foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Category parent;

    @OneToMany(mappedBy = "parent")
    @Builder.Default
    private List<Category> children = new ArrayList<>();

    public void settingParent(Category parent) {
        this.parent =  parent;
    }
}