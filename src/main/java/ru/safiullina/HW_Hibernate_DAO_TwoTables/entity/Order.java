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
    private int id; // `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    @Column(nullable = false)
    private Date date; //`date` DATE NOT NULL,
    @Column(nullable = false)
    private String product_name; //`product_name` VARCHAR(255),
    @Column(nullable = false, length = 9, precision = 2)
    private float amount; //`amount` DECIMAL(9,2),

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Customer customer; //`customer_id` INT UNSIGNED,

    public Order(Date date, String product_name, float amount, Customer customer) {
        this.date = date;
        this.product_name = product_name;
        this.amount = amount;
        this.customer = customer;
    }

}
