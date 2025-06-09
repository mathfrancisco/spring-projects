package study.projects_spring.firstendpoint.service;

import org.springframework.stereotype.Service;
import study.projects_spring.firstendpoint.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

   public Person findById(String id){
       logger.info("Finding one Person!");

       Person person = new Person();
       person.setId(counter.incrementAndGet());
       person.setFirstName("Matheus");
       person.setLastName("Francisco");
       person.setAddress("Sao paulo - Brazil");
       person.setGender("Male");
       return person;
   }

   public List<Person> findAll(){
       logger.info("Finding all Person!");
       List<Person> persons = new ArrayList<Person>();
       for (int i = 0; i<8;i++){
           Person person = mockPerson(i);
           persons.add(person);
       }
       return persons;
   }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname"+i);
        person.setLastName("LastName"+i);
        person.setAddress("Sao paulo - Brazil");
        person.setGender("Male");
        return person;
    }
    public Person create(Person person){
        logger.info("Creating a new Person!");

        return person;
    }
    public Person update(Person person){
        logger.info("Updating a Person!");

        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");

    }

}
