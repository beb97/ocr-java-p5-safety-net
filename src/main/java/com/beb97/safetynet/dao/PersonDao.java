package com.beb97.safetynet.dao;

import com.beb97.safetynet.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {


//    List<Person> saveAll(List<Person> persons);

    Person save(Person person);
}
