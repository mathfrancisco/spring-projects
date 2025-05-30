package study.projects_spring.firstendpoint.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.projects_spring.firstendpoint.exception.UnsurpportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {
    //http:localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1)|| !isNumeric(number2))throw new UnsurpportedMathOperationException("Please set a numeric value");
        return convertToDouble(number1) + convertToDouble(number2);

    }
    private Double convertToDouble(String strNumber)throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsurpportedMathOperationException("Please set a numeric value");
        String number = strNumber.replace(",",".");
        return  Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",","."); //R$5,00 USD 5.0
        return  (number.matches("[-+]?[0-9]*\\.?[0-9]+")) ;
    }

    //http:localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{number1}/{number2}")
    public Double sub(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1)|| !isNumeric(number2))throw new UnsurpportedMathOperationException("Please set a numeric value");
        return convertToDouble(number1) - convertToDouble(number2);

    }

    //http:localhost:8080/math/division/3/5
    @RequestMapping("/division/{number1}/{number2}")
    public Double div(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1)|| !isNumeric(number2))throw new UnsurpportedMathOperationException("Please set a numeric value");
        return convertToDouble(number1) / convertToDouble(number2);

    }
    //http:localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{number1}/{number2}")
    public Double mean(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2) throws Exception {
        if(!isNumeric(number1)|| !isNumeric(number2))throw new UnsurpportedMathOperationException("Please set a numeric value");
        return (convertToDouble(number1) + convertToDouble(number2)) / 2;

    }

    //http:localhost:8080/math/squareRoot/3/5
    @RequestMapping("/squareRoot/{number1}")
    public Double squareRoot(
            @PathVariable("number1") String number1) throws Exception {
        if(!isNumeric(number1))throw new UnsurpportedMathOperationException("Please set a numeric value");
        return Math.sqrt(convertToDouble(number1));

    }

}
