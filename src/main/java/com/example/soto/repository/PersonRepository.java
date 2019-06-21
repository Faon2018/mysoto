package com.example.soto.repository;

import com.example.soto.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface PersonRepository  extends JpaRepository<Person,Long> , JpaSpecificationExecutor<Person>, Serializable {
}
