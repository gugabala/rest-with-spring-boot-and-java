package br.com.erudio.controller;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServices  service;


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() throws Exception {

        return service.findAll();
    }
    @GetMapping(value="/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") Long id ) throws Exception {

        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody  PersonVO person ) throws Exception {

        return service.create(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody  PersonVO person ) throws Exception {

        return service.update(person);
    }

    @DeleteMapping(value="/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id ) throws Exception {

         service.delete(id);
         return  ResponseEntity.noContent().build();
    }


}
