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
    public void abc(){
        personRepository.deleteAll();
        Person o = new Person("Michael");
        personRepository.save(o);
        assertEquals(o, personRepository.findByNameContaining("icha"));
    }
}