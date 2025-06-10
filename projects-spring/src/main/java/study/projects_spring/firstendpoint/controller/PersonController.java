package study.projects_spring.firstendpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import study.projects_spring.firstendpoint.model.Person;
import study.projects_spring.firstendpoint.service.PersonService;
import java.util.List;

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

    /**
     * Endpoint para buscar uma pessoa pelo ID.
     * - value = "/{id}": Define que a URL será /person/algum-id (ex: /person/1).
     * - method = RequestMethod.GET: Especifica que este método responde a requisições HTTP GET.
     * - produces = MediaType.APPLICATION_JSON_VALUE: Indica que a resposta será no formato JSON.
     * - @PathVariable("id") String id: Pega o valor do "{id}" da URL e o atribui à variável 'id'.
     */
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id){
        // Delega a busca para a camada de serviço (service)
        return   service.findById(id);
    }

    /**
     * Endpoint para criar uma nova pessoa.
     * - method = RequestMethod.POST: Responde a requisições HTTP POST, usadas para criar novos recursos.
     * - consumes = MediaType.APPLICATION_JSON_VALUE: Indica que este método espera receber dados em JSON no corpo da requisição.
     * - @RequestBody Person person: Converte o JSON do corpo da requisição em um objeto Java do tipo 'Person'.
     */
    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){
        // Delega a criação para a camada de serviço
        return   service.create(person);
    }

    /**
     * Endpoint para atualizar os dados de uma pessoa.
     * - method = RequestMethod.PUT: Responde a requisições HTTP PUT, usadas para atualizar recursos existentes.
     * - @RequestBody Person person: Assim como no 'create', pega os dados do corpo da requisição.
     */
    @RequestMapping(value = "update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person){
        // Delega a atualização para a camada de serviço
        return   service.update(person);
    }

    /**
     * Endpoint para listar todas as pessoas cadastradas.
     * - method = RequestMethod.GET: Responde a requisições HTTP GET.
     * - URL: /person/findAll
     */
    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll( ){
        // Delega a busca de todos os registros para a camada de serviço
        return   service.findAll();
    }

    /**
     * Endpoint para deletar uma pessoa pelo ID.
     * - method = RequestMethod.DELETE: Responde a requisições HTTP DELETE.
     * - @PathVariable("id"): Pega o ID da URL para saber qual pessoa deletar.
     * - O método é 'void' porque, geralmente, uma operação de delete bem-sucedida
     * não precisa retornar nenhum conteúdo no corpo da resposta (apenas um status HTTP 204 No Content).
     */
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}