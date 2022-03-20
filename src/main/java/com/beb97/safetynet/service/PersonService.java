package com.beb97.safetynet.service;

import com.beb97.safetynet.repository.PersonDao;
import com.beb97.safetynet.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

//    https://openclassrooms.com/fr/courses/6900101-creez-une-application-java-avec-spring-boot/7078015-creez-un-controleur-rest-pour-gerer-vos-donnees

    public Iterable<Person> getAll() {
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person());
        return personDao.findAll();
    }

    public Person getById(Integer id) {
        Person person = null;
        person = personDao.findById(id).get();
        return person;
    }

    public Person save(Person person) {
        return personDao.save(person);
    }


    public Boolean update(Person person, Integer id) {
//        Person personSaved = null;

        Optional<Person> personOptional = personDao.findById(id);
        if (!personOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
            return false;
        }

        person.setId(id);
        personDao.save(person);
        return true;
    }

    public void deleteById(Integer id) {
        personDao.deleteById(id);
//        return;
    }


}
