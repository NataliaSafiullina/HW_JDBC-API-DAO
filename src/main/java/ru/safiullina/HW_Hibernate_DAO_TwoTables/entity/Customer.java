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
    @Column(name = "id")
    private int id; //`id`INT UNSIGNED NOT NULL AUTO_INCREMENT,

    @Column(name = "name", nullable = false)
    private String name; //`name` VARCHAR(255) NOT NULL,

    @Column(name = "surname", nullable = false)
    private String surname; //`surname` VARCHAR(255) NOT NULL,

    @Column(name = "age", nullable = false)
    private int age; //`age` INT NOT NULL CHECK (`age`>= 0),

    @Column(name = "phone_number")
    private String phoneNumber; //`phone_number` VARCHAR(20),

    public Customer(String name, String surname, int age, String phone_number) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phone_number;
    }

}
