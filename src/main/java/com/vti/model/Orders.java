package com.vti.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    // @Fetch(FetchType.)
    // lazy => query order ko lấy product
    // erger => query order có lấy product
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "sub_total")
    private BigDecimal subTotal;  // Subtotal price of all items

    @Column(name = "shipping")
    private BigDecimal shipping;  // Shipping cost

    @Column(name = "total")
    private BigDecimal total;     // Total order amount

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Status status = Status.INIT;


    @OneToOne()
    private OrdersPayment orderPayment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private List<OrdersProduct> ordersProducts;

    public enum Status {
        INIT, PROCESSING, COMPLETE
    }
}
