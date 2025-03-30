package com.example.assignment.brand.domain;

import com.example.assignment.common.jpa.BaseEntity;
import com.example.assignment.common.jpa.CustomIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Collate;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Entity
@Table(name = "brand")
@DynamicUpdate
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand extends BaseEntity {

    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(
            name = "id_generator",
            strategy = "com.example.assignment.common.jpa.JpaIdGenerator"
    )
    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "homepage_url")
    private String homepageUrl;

}
