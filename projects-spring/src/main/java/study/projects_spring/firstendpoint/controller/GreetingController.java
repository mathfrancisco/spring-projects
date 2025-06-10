package study.projects_spring.firstendpoint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.projects_spring.firstendpoint.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    // Template da mensagem de saudação. %s será substituído pelo nome.
    private static final String template="Hello, %s!";

    // Um contador atômico para gerar IDs únicos e seguros em ambientes com múltiplas threads.
    private final AtomicLong counter = new AtomicLong();

    /**
     * Endpoint de saudação.
     * URL de exemplo: http://localhost:8080/greeting?name=Leandro
     *
     * @RequestMapping("/greeting"): Mapeia a URL /greeting para este método.
     *
     * @RequestParam: Pega um parâmetro da query string da URL.
     * - value = "name": O nome do parâmetro na URL (ex: ?name=...).
     * - defaultValue = "World": Se o parâmetro 'name' não for fornecido, 'World' será usado como padrão.
     */
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")  String name){
        // Retorna um novo objeto Greeting com um ID incrementado e a mensagem formatada.
        // O Spring converterá este objeto em JSON automaticamente.
        return  new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}