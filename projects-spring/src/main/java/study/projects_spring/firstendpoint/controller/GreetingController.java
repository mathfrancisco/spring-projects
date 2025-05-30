package study.projects_spring.firstendpoint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.projects_spring.firstendpoint.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template="Hello,%s!";
    private final AtomicLong counter = new AtomicLong();
    //http:/localhost:8080/greeting?name=leandro
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Word")  String name){
        return  new Greeting(counter.incrementAndGet(),String.format(template,name));

    }
}
