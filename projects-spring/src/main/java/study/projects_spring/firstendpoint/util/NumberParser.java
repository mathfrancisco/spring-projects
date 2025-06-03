package study.projects_spring.firstendpoint.util;

import study.projects_spring.firstendpoint.exception.UnsurpportedMathOperationException;

public class NumberParser {

    public static Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            throw new UnsurpportedMathOperationException("Por favor, defina um valor numérico.");
        }
        String number = strNumber.replace(",", ".");
        if (!isNumeric(number)) { // Valida após a substituição da vírgula
            throw new UnsurpportedMathOperationException("Por favor, defina um valor numérico válido.");
        }
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return false;
        }
        // A validação com regex já ocorre em convertToDouble após o replace,
        // mas podemos manter uma verificação básica aqui se necessário antes do replace.
        // No entanto, para este fluxo, a validação principal é melhor após o replace.
        String number = strNumber.replace(",", "."); // Necessário para a regex funcionar com ambos os formatos
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}