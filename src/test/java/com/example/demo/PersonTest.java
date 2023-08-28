package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void savePerson(){
        personRepository.deleteAll();
        Person p = new Person("Thomas", 12);
        personRepository.save(p);
        assertEquals("Thomas", personRepository.findByAgeGreaterThan(10).getName());
    }

}