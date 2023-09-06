package com.vti.form;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductCreateForm {
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Integer stockNumber;
}
