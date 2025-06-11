package study.projects_spring.firstendpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.projects_spring.firstendpoint.exception.ResourceNotFoundException;
import study.projects_spring.firstendpoint.model.Person;
import study.projects_spring.firstendpoint.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    // Contador atômico para gerar IDs únicos de forma segura.
    private final AtomicLong counter = new AtomicLong();

    // Objeto Logger para registrar informações sobre a execução dos métodos.
    // É uma prática recomendada para depuração e monitoramento.
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    /**
     * Busca uma pessoa.
     * ATENÇÃO: Esta é uma implementação "mocada" (simulada).
     * Em uma aplicação real, este método buscaria os dados de um banco de dados usando o 'id'.
     * @param id O ID da pessoa a ser buscada (atualmente não utilizado na lógica).
     * @return Um objeto Person com dados fixos.
     */
    public Person findById(Long id){
        logger.info("Finding one Person!"); // Registra uma mensagem de log.
        return personRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
    }

    /**
     * Lista todas as pessoas.
     * ATENÇÃO: Implementação "mocada". Cria uma lista de pessoas dinamicamente.
     * Em um cenário real, buscaria todos os registros de pessoa do banco de dados.
     * @return Uma lista de objetos Person.
     */
    public List<Person> findAll(){
        logger.info("Finding all Person!");

        return personRepository.findAll();
    }

    /**
     * Método auxiliar privado para criar um objeto Person simulado.
     * @param i Um número para diferenciar os dados de cada pessoa.
     * @return Um novo objeto Person.
     */
//    private Person mockPerson(int i) {
//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFirstName("Firstname " + i);
//        person.setLastName("LastName " + i);
//        person.setAddress("Some address in Brazil " + i);
//        person.setGender("Male");
//        return person;
//    }

    /**
     * Cria uma nova pessoa.
     * ATENÇÃO: Versão "mocada". Apenas retorna o objeto recebido.
     * Em uma aplicação real, este método salvaria o objeto 'person' no banco de dados.
     * @param person O objeto Person a ser criado.
     * @return O objeto Person que foi "salvo".
     */
    public Person create(Person person){
        logger.info("Creating a new Person!");
         person.setId(null);
        return personRepository.save(person);
    }

    /**
     * Atualiza uma pessoa existente.
     * ATENÇÃO: Versão "mocada". Apenas retorna o objeto recebido.
     * Em uma aplicação real, buscaria a pessoa pelo ID e atualizaria seus dados no banco.
     * @param person O objeto Person com os dados atualizados.
     * @return O objeto Person atualizado.
     */
    public Person update(Person person){
        logger.info("Updating a Person!");

        Person entity= personRepository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    /**
     * Deleta uma pessoa.
     * ATENÇÃO: Versão "mocada". Não executa nenhuma lógica de exclusão.
     * Em uma aplicação real, removeria o registro correspondente ao 'id' do banco de dados.
     * @param id O ID da pessoa a ser deletada.
     */
    public void delete(Long id){
        logger.info("Deleting one Person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
        personRepository.delete(entity);
    }
}