package com.example.demo;

import jakarta.persistence.*;
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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Getter
    String name;

    int age;

    public Person(String name) {
        this.name = name;
    }

    public void test5 (){
        System.out.println("haha");
    }

}
