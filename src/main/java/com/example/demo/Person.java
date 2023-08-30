package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
um von spring data gemanaged zu werden brauchen wir:
@Entitty
@Id

Konstruktor ohne Argumente
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    String password;

    int age;

    public Person(String name) {
        this.name = name;
    }
}
