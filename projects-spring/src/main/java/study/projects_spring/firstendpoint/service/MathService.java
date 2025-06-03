package study.projects_spring.firstendpoint.service;

import org.springframework.stereotype.Service;
import study.projects_spring.firstendpoint.exception.UnsurpportedMathOperationException;
import study.projects_spring.firstendpoint.util.NumberParser; // Importe a classe auxiliar

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);
        return num1 + num2;
    }

    public Double subtraction(String numberOne, String numberTwo) {
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);
        return num1 - num2;
    }

    public Double division(String numberOne, String numberTwo) {
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);
        if (num2 == 0) {
            throw new UnsurpportedMathOperationException("Divisão por zero não é permitida.");
        }
        return num1 / num2;
    }

    public Double mean(String numberOne, String numberTwo) {
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);
        return (num1 + num2) / 2;
    }

    public Double squareRoot(String number) {
        double num = NumberParser.convertToDouble(number);
        if (num < 0) {
            throw new UnsurpportedMathOperationException("Raiz quadrada de número negativo não é permitida para números reais.");
        }
        return Math.sqrt(num);
    }
}