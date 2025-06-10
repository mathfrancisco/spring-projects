package study.projects_spring.firstendpoint.service;

import org.springframework.stereotype.Service;
import study.projects_spring.firstendpoint.exception.UnsurpportedMathOperationException;
import study.projects_spring.firstendpoint.util.NumberParser;

/**
 * @Service: Anotação que marca esta classe como um componente de serviço na camada de negócios.
 * O Spring a gerencia e a torna elegível para injeção de dependência (com @Autowired) em outras classes,
 * como nos Controllers.
 */
@Service
public class MathService {

    /**
     * Realiza a soma de dois números.
     * @param numberOne O primeiro número em formato String.
     * @param numberTwo O segundo número em formato String.
     * @return O resultado da soma como um Double.
     */
    public Double sum(String numberOne, String numberTwo) {
        // Delega a conversão e validação das Strings para a classe utilitária.
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);
        // Retorna o resultado da operação.
        return num1 + num2;
    }

    /**
     * Realiza a subtração de dois números.
     */
    public Double subtraction(String numberOne, String numberTwo) {
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);
        return num1 - num2;
    }

    /**
     * Realiza a divisão de dois números.
     * Inclui uma regra de negócio específica: não permitir divisão por zero.
     */
    public Double division(String numberOne, String numberTwo) {
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);

        // Regra de negócio: Validação para evitar a divisão por zero.
        if (num2 == 0) {
            // Lança uma exceção customizada para informar o erro específico ao usuário.
            throw new UnsurpportedMathOperationException("Divisão por zero não é permitida.");
        }
        return num1 / num2;
    }

    /**
     * Calcula a média de dois números.
     */
    public Double mean(String numberOne, String numberTwo) {
        Double num1 = NumberParser.convertToDouble(numberOne);
        Double num2 = NumberParser.convertToDouble(numberTwo);
        return (num1 + num2) / 2;
    }

    /**
     * Calcula a raiz quadrada de um número.
     * Inclui uma regra de negócio para números reais: não permitir raiz de número negativo.
     */
    public Double squareRoot(String number) {
        double num = NumberParser.convertToDouble(number);

        // Regra de negócio: Validação para evitar a raiz de número negativo.
        if (num < 0) {
            throw new UnsurpportedMathOperationException("Raiz quadrada de número negativo não é permitida para números reais.");
        }

        // Usa a função sqrt da classe Math do Java para o cálculo.
        return Math.sqrt(num);
    }
}