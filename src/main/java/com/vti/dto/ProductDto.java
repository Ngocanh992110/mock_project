package com.vti.dto;

import com.vti.model.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ProductDto {
    private Integer id;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Integer stockNumber;
}
