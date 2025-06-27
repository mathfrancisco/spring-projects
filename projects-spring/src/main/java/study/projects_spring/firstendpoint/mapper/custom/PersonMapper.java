package study.projects_spring.firstendpoint.mapper.custom;

import study.projects_spring.firstendpoint.model.Person;
import study.projects_spring.firstendpoint.model.dto.v2.PersonDtoV2;

import java.util.Date;

public class PersonMapper {
    public PersonDtoV2 convertEntiToDto(Person person){
        PersonDtoV2 dto = new PersonDtoV2();
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }
    public Person convertDtoToEntity(PersonDtoV2 personDto){
        Person entity = new Person();
        entity.setFirstName(personDto.getFirstName());
        entity.setLastName(personDto.getLastName());
        // Note: You should handle the birthday mapping appropriately.
        // Setting it to the current date on every conversion might not be the desired behavior.
        // entity.setBirthDay(personDto.getBirthDay());
        entity.setAddress(personDto.getAddress());
        entity.setGender(personDto.getGender());
        return entity;
    }
}
