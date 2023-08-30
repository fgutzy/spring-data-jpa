package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void savePerson(){
        Person p = new Person("Thomas");
        Person o = new Person("Otto");
        Person i = new Person("Peter");
        personRepository.save(p);
        personRepository.save(o);
        personRepository.save(i);
    }

}