package study.projects_spring.firstendpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.projects_spring.firstendpoint.model.dto.v1.PersonDto;
import study.projects_spring.firstendpoint.model.dto.v2.PersonDtoV2;
import study.projects_spring.firstendpoint.service.PersonService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @RestController: Anotação que combina @Controller e @ResponseBody.
 * Ela informa ao Spring que esta classe é um controlador REST,
 * e os métodos retornarão dados (como JSON) diretamente no corpo da resposta HTTP.
 */
@RestController
/**
 * @RequestMapping("/person"): Mapeia todas as requisições que começam com "/person"
 * para este controlador. É a URL base para todos os endpoints definidos nesta classe.
 */
@RequestMapping("/person")
public class PersonController {

    /**
     * @Autowired: Mecanismo de injeção de dependência do Spring.
     * Ele "injeta" uma instância de PersonService (que contém a lógica de negócio)
     * nesta classe, sem que precisemos criá-la manualmente com 'new PersonService()'.
     */
    @Autowired
    private PersonService service;

    private final Logger logger = LoggerFactory.getLogger(PersonController.class.getName());

    /**
     * Endpoint para buscar uma pessoa pelo ID.
     * - value = "/{id}": Define que a URL será /person/algum-id (ex: /person/1).
     * - method = RequestMethod.GET: Especifica que este método responde a requisições HTTP GET.
     * - produces = MediaType.APPLICATION_JSON_VALUE: Indica que a resposta será no formato JSON.
     * - @PathVariable("id") String id: Pega o valor do "{id}" da URL e o atribui à variável 'id'.
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto findById(@PathVariable("id") Long id) {
        logger.info("Finding one person!");

        return service.findById(id);
    }

    /**
     * Endpoint para criar uma nova pessoa.
     * - method = RequestMethod.POST: Responde a requisições HTTP POST, usadas para criar novos recursos.
     * - consumes = MediaType.APPLICATION_JSON_VALUE: Indica que este método espera receber dados em JSON no corpo da requisição.
     * - @RequestBody Person person: Converte o JSON do corpo da requisição em um objeto Java do tipo 'Person'.
     */
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto create(@RequestBody PersonDto person) {
        logger.info("Creating one person!");

        return service.create(person);
    }
//@PostMapping(name = "/v2",
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public PersonDtoV2 create(@RequestBody PersonDtoV2 person) {
//        logger.info("Creating one person!");
//
//        return service.createV2(person);
//    }

    /**
     * Endpoint para atualizar os dados de uma pessoa.
     * - method = RequestMethod.PUT: Responde a requisições HTTP PUT, usadas para atualizar recursos existentes.
     * - @RequestBody Person person: Assim como no 'create', pega os dados do corpo da requisição.
     */
    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto update(@RequestBody PersonDto person) {
        logger.info("Updating one person!");

        return service.update(person);
    }

    /**
     * Endpoint para listar todas as pessoas cadastradas.
     * - method = RequestMethod.GET: Responde a requisições HTTP GET.
     * - URL: /person/findAll
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findAll() {
        logger.info("Finding all person!");

        return service.findAll();
    }

    /**
     * Endpoint para deletar uma pessoa pelo ID.
     * - method = RequestMethod.DELETE: Responde a requisições HTTP DELETE.
     * - @PathVariable("id"): Pega o ID da URL para saber qual pessoa deletar.
     * - O método é 'void' porque, geralmente, uma operação de delete bem-sucedida
     * não precisa retornar nenhum conteúdo no corpo da resposta (apenas um status HTTP 204 No Content).
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        logger.info("Deleting one person!");

        service.delete(id);
        // Retorna um status HTTP 204 No Content, que é o padrão para delete bem-sucedido.
        return ResponseEntity.noContent().build();
    }
}