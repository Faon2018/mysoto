package com.example.soto.service.impl;

import com.example.soto.entity.Person;
import com.example.soto.repository.PersonRepository;
import com.example.soto.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements  PersonService {

    @Autowired
    private  PersonRepository  personRepository;
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
