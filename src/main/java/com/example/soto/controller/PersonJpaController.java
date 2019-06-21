package com.example.soto.controller;


import com.example.soto.entity.Person;
import com.example.soto.repository.PersonRepository;
import com.example.soto.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonJpaController {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    /**
     * 数据新增或更新，save方法可以执行添加也可以执行更新，如果需要执行持久化的实体存在主键值则更新数据，如果不存在则添加数据。
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public Person save(Person person) {
        return  personServiceImpl.save(person);
    }

}

