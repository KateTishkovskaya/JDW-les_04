package by.training.les_04.logic;

/**
 * class SyntaticAnalyze отвечает за синтаксичейский
 * разбор выражения (метод рекурсивного спуска)
 *
 * @author K.P.Tishkovskaya
 * @version 1.3 28.02.2022
 */
public class SyntacticAnalyze {
    static int pos = 0;

    /**
     * Метод, запускающий разбор выражения
     * @param tokens - принимает выражение, разбитое на массив строк
     * @return result
     */
    public static Double parse(String[] tokens) {
        Double result = plusMinus(tokens);
        return result;
    }

    /**
     * Метод, вычисляющий операции "+" и "-"
     * @param tokens - принимает выражение, разбитое на массив строк
     * @return value
     */
    private static Double plusMinus(String[] tokens) {
        // находим первое слагаемое
        Double firstTerm = multDiv(tokens);

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            // находим второе слагаемое (вычитаемое)
            Double secondTerm = multDiv(tokens);
            if (operator.equals("+")) {
                firstTerm += secondTerm;
            } else {
                firstTerm -= secondTerm;
            }
        }
        return firstTerm;
    }

    /**
     * Метод, вычисляющий операции "*" и "/"
     * @param tokens - принимает выражение, разбитое на массив строк
     * @return value
     */
    private static Double multDiv(String[] tokens) {
        // находим первый множитель
        Double firstFactor = factor(tokens);

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            // находим второй множитель (делитель)
            Double secondFactor = factor(tokens);
            if (operator.equals("*")) {
                firstFactor *= secondFactor;
            } else {
                firstFactor /= secondFactor;
            }
        }
        return firstFactor;
    }

    /**
     * Метод, который при нахождении ")" возвращет нас в метод plusMinus
     * и парсит числа
     * @param tokens - принимает выражение, разбитое на массив строк
     * @return result
     */
    private static Double factor(String[] tokens) {
        String next = tokens[pos];
        Double result;
        if (next.equals("(")) {
            pos++;
            //если встретили скобки, то запускаем метод plusMinus
            result = plusMinus(tokens);

            String closingBracket = tokens[pos];
            if (pos < tokens.length && closingBracket.equals(")")) {
                pos++;
                return result;
            }
        }
        pos++;
        return Double.parseDouble(next);
    }
}
