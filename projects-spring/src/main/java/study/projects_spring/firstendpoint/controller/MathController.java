package study.projects_spring.firstendpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.projects_spring.firstendpoint.service.MathService;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService; // Injeção do serviço

    // http:localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.sum(number1, number2);
    }

    // http:localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{number1}/{number2}")
    public Double subtraction(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.subtraction(number1, number2);
    }

    // http:localhost:8080/math/division/3/5
    @RequestMapping("/division/{number1}/{number2}")
    public Double division(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.division(number1, number2);
    }

    // http:localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{number1}/{number2}")
    public Double mean(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) {
        return mathService.mean(number1, number2);
    }

    // http:localhost:8080/math/squareRoot/3
    @RequestMapping("/squareRoot/{number1}")
    public Double squareRoot(
            @PathVariable("number1") String number1) {
        return mathService.squareRoot(number1);
    }
}