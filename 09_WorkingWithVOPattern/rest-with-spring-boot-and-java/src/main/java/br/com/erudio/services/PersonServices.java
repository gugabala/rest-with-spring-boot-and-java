package br.com.erudio.services;


import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
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

    public List<PersonVO> findAll() {
        logger.info("Find All people!");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }


    public PersonVO findById(Long id) {
        logger.info("Findind one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO personVO) {

        logger.info("creating one person!");
        var entity = DozerMapper.parseObject(personVO, Person.class);
        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);

    }

    public PersonVO update(PersonVO person) {

        logger.info("updating one person!");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));

        repository.delete(entity);
    }
}
