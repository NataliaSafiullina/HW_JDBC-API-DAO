package ru.safiullina.HW_Hibernate_DAO_TwoTables.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; // `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name = "date", nullable = false)
    private Date date; //`date` DATE NOT NULL,

    @Column(name = "product_name", nullable = false)
    private String productName; //`product_name` VARCHAR(255),

    @Column(name = "amount", nullable = false, length = 9, precision = 2)
    private float amount; //`amount` DECIMAL(9,2),

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Customer customer; //`customer_id` INT UNSIGNED,

    public Order(Date date, String product_name, float amount, Customer customer) {
        this.date = date;
        this.productName = product_name;
        this.amount = amount;
        this.customer = customer;
    }

}
