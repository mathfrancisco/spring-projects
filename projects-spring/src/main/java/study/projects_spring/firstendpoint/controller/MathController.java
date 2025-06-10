package study.projects_spring.firstendpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.projects_spring.firstendpoint.service.MathService;

@RestController
@RequestMapping("/math") // URL base: /math
public class MathController {

    // Injeta a dependência do serviço que contém a lógica dos cálculos
    @Autowired
    private MathService mathService;

    /**
     * Endpoint para somar dois números.
     * URL de exemplo: http://localhost:8080/math/sum/3/5
     * @PathVariable captura os valores "3" e "5" da URL.
     * Os números são recebidos como String e serão convertidos na camada de serviço.
     */
    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.sum(number1, number2);
    }

    /**
     * Endpoint para subtrair dois números.
     * URL de exemplo: http://localhost:8080/math/subtraction/3/5
     */
    @RequestMapping("/subtraction/{number1}/{number2}")
    public Double subtraction(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.subtraction(number1, number2);
    }

    /**
     * Endpoint para dividir dois números.
     * URL de exemplo: http://localhost:8080/math/division/3/5
     */
    @RequestMapping("/division/{number1}/{number2}")
    public Double division(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.division(number1, number2);
    }

    /**
     * Endpoint para calcular a média de dois números.
     * URL de exemplo: http://localhost:8080/math/mean/3/5
     */
    @RequestMapping("/mean/{number1}/{number2}")
    public Double mean(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.mean(number1, number2);
    }

    /**
     * Endpoint para calcular a raiz quadrada de um número.
     * URL de exemplo: http://localhost:8080/math/squareRoot/9
     */
    @RequestMapping("/squareRoot/{number1}")
    public Double squareRoot(
            @PathVariable("number1") String number1) {
        return mathService.squareRoot(number1);
    }
}