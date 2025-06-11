package study.projects_spring.firstendpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.projects_spring.firstendpoint.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
