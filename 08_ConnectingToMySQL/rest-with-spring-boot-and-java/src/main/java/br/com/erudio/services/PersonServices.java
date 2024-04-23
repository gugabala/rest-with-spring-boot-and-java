package br.com.erudio.services;


import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.reositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Find All people!");

        return repository.findAll();
    }

//    private Person mockPerson(int i) {
//        Person person =new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFisrtName("Person Name "+ i);
//        person.setLastName("Last Name "+i);
//        person.setAddress("Aracaju");
//        person.setGender("Male");
//        return person;
//    }

    public Person findById(Long id) {
        logger.info("Findind one person!");
//        Person person =new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFisrtName("Gustavo");
//        person.setLastName("Garcez");
//        person.setAddress("Aracaju");
//        person.setGender("Male");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));

    }

    public Person create(Person person) {

        logger.info("creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("updating one person!");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));

        entity.setFisrtName(person.getFisrtName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));

        repository.delete(entity);
    }
}
