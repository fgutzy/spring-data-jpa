package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByAgeGreaterThan(int age);

    boolean existsByNameAndPassword(String name, String password);

    boolean existsByName(String name);
}
