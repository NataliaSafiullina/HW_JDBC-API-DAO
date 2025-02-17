package ru.safiullina.HW_Hibernate_DAO_TwoTables.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //`id`INT UNSIGNED NOT NULL AUTO_INCREMENT,
    @Column(nullable = false)
    private String name; //`name` VARCHAR(255) NOT NULL,
    @Column(nullable = false)
    private String surname; //`surname` VARCHAR(255) NOT NULL,
    @Column(nullable = false)
    private int age; //`age` INT NOT NULL CHECK (`age`>= 0),
    private String phone_number; //`phone_number` VARCHAR(20),

    public Customer(String name, String surname, int age, String phone_number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone_number = phone_number;
    }

}
