package com.example.assignment.products.domains.id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProductItemId implements Serializable {
    private Long productItemId;
    private String stockKeepingUnitCode;
}
