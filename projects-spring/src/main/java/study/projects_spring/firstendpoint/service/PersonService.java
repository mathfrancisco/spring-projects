package study.projects_spring.firstendpoint.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.projects_spring.firstendpoint.exception.ResourceNotFoundException;
import study.projects_spring.firstendpoint.mapper.custom.PersonMapper;
import study.projects_spring.firstendpoint.model.Person;
import study.projects_spring.firstendpoint.model.dto.v1.PersonDto;
import study.projects_spring.firstendpoint.repository.PersonRepository;
import java.util.List;

import static study.projects_spring.firstendpoint.mapper.DozerMapper.parseListObjects;
import static study.projects_spring.firstendpoint.mapper.DozerMapper.parseObject;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

//    @Autowired
//    PersonMapper personMapper;

    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public PersonDto findById(Long id){
        logger.info("Finding one Person!");
        var entity = personRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
        return parseObject(entity, PersonDto.class);
    }

    public List<PersonDto> findAll(){
        logger.info("Finding all People!");
        return parseListObjects(personRepository.findAll(), PersonDto.class);
    }

    public PersonDto create(PersonDto personDto){
        logger.info("Creating one person!");
        var entity = parseObject(personDto, Person.class);
        return parseObject(personRepository.save(entity), PersonDto.class);
    }
//    public PersonDtoV2 createV2(PersonDtoV2 person){
//        logger.info("Creating one person!");
//        var entity = personMapper.convertDtoToEntity(person);
//        return personMapper.convertEntiToDto(personRepository.save(entity));
//    }

    public PersonDto update(PersonDto personDto){
        logger.info("Updating a Person!");

        Person entity = personRepository.findById(personDto.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(personDto.getFirstName());
        entity.setLastName(personDto.getLastName());
        entity.setAddress(personDto.getAddress());
        entity.setGender(personDto.getGender());

        return parseObject(personRepository.save(entity), PersonDto.class);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");
        Person entity = personRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
        personRepository.delete(entity);
    }
}