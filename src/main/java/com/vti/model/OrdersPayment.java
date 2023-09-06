package com.vti.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "orders_payment")
public class OrdersPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(mappedBy = "orderPayment", cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders orders;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;
    public enum PaymentStatus {
        NOT_PAID, PAID
    }

}
