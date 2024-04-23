package br.com.erudio.services;


import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Find All people!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person =new Person();
        person.setId(counter.incrementAndGet());
        person.setFisrtName("Person Name "+ i);
        person.setLastName("Last Name "+i);
        person.setAddress("Aracaju");
        person.setGender("Male");
        return person;
    }

    public Person findById(String id){
        logger.info("Findind one person!");
        Person person =new Person();
        person.setId(counter.incrementAndGet());
        person.setFisrtName("Gustavo");
        person.setLastName("Garcez");
        person.setAddress("Aracaju");
        person.setGender("Male");
        return person;

    }

    public Person create (Person person){

        logger.info("creating one person!");
        return person;
    }

    public Person update (Person person){

        logger.info("creating one person!");
        return person;
    }

    public void delete (String id){

        logger.info("Deleting one person!");

    }
}
