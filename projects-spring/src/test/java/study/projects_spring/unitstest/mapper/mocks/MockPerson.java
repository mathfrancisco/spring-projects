package study.projects_spring.unitstest.mapper.mocks;

import study.projects_spring.firstendpoint.model.Person;
import study.projects_spring.firstendpoint.model.dto.v1.PersonDto;
import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonDto mockDto() {
        // CORREÇÃO: Passar o número 0, assim como no mockEntity()
        return mockDTO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDto> mockDTOList() {
        List<PersonDto> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            // CORREÇÃO: Passar a variável do loop 'i' para o método
            persons.add(mockDTO(i));
        }
        return persons;
    }

    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    // CORREÇÃO PRINCIPAL: Adicionado o parâmetro (Integer number)
    public PersonDto mockDTO(Integer number) {
        PersonDto person = new PersonDto();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }
}