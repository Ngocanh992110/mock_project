package com.vti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor // Tạo constructor all tham số
@NoArgsConstructor // Tạo constructor không tham số
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;


    @Column(name = "brand")
    @Enumerated(value = EnumType.STRING)
    private Brand brand;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock_number")
    private Integer stockNumber;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrdersProduct> orderProducts;

    public enum Category {
        OFFICE, GRAPHIC, GAMING
    }

    public enum Brand {
        LENOVO, HP, MAC, ASUS, DELL, APPLE
    }


}
