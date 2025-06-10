package study.projects_spring.firstendpoint.util;

import study.projects_spring.firstendpoint.exception.UnsurpportedMathOperationException;

/**
 * Classe utilitária com métodos estáticos para manipulação de números.
 * Métodos 'static' podem ser chamados diretamente pela classe (ex: NumberParser.convertToDouble()),
 * sem precisar criar um objeto dela.
 */
public class NumberParser {

    /**
     * Converte uma String para um Double.
     * Lida com números que usam tanto ponto (.) quanto vírgula (,) como separador decimal.
     * @param strNumber A string a ser convertida.
     * @return O valor em Double.
     * @throws UnsurpportedMathOperationException se a string for nula, vazia ou não for um número válido.
     */
    public static Double convertToDouble(String strNumber) {
        // Validação inicial: não aceita nulo ou vazio.
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsurpportedMathOperationException("Por favor, defina um valor numérico.");
        }

        // Padroniza o separador decimal para ponto, para que o Java consiga interpretar.
        String number = strNumber.replace(",", ".");

        // Valida se a string padronizada é realmente um número.
        if (!isNumeric(number)) {
            throw new UnsurpportedMathOperationException("Por favor, defina um valor numérico válido.");
        }

        // Converte a string validada para Double.
        return Double.parseDouble(number);
    }

    /**
     * Verifica se uma String é um número válido.
     * @param strNumber A string a ser verificada.
     * @return 'true' se for um número, 'false' caso contrário.
     */
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        // Garante que a verificação funcione com vírgula ou ponto.
        String number = strNumber.replace(",", ".");

        // Usa uma expressão regular (regex) para verificar o formato do número.
        // A regex "[-+]?[0-9]*\\.?[0-9]+" aceita números positivos, negativos, inteiros e com ponto flutuante.
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}