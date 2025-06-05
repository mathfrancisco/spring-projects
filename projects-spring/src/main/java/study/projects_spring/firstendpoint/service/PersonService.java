package study.projects_spring.firstendpoint.service;

import org.springframework.stereotype.Service;
import study.projects_spring.firstendpoint.model.Person;

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




}
