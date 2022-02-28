package by.training.les_04.logic;

import by.training.les_04.logic.LexAnalyze;

public class SyntacticAnalyze {
    private LexAnalyze.Lexeme[] tokens;
    private int pos = 0; // индекс текущего токена

    public SyntacticAnalyze(LexAnalyze.Lexeme[] tokens) {
        this.tokens = tokens;
    }

    public Double parse() {
        Double result = expression();
        if (pos != tokens.length) {
            throw new IllegalStateException("Error in expression at " + tokens[pos]);
        }
        return result;
    }

    // E -> T±T±T±T± ... ±T
    private Double expression() {
        // находим первое слагаемое
        Double first = term();

        while (pos < tokens.length) {
            LexAnalyze.Lexeme operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            // находим второе слагаемое (вычитаемое)
            Double second = term();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    // T -> F*/F*/F*/*/ ... */F
    private Double term() {
        // находим первый множитель
        Double first = factor();

        while (pos < tokens.length) {
            LexAnalyze.Lexeme operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            // находим второй множитель (делитель)
            Double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    // F -> N | (E)
    private Double factor() {
        LexAnalyze.Lexeme next = tokens[pos];
        Double result;
        if (next.equals("(")) {
            pos++;
            // если выражение в скобках, то рекурсивно переходим на обработку подвыражения типа Е
            result = expression();
            LexAnalyze.Lexeme closingBracket;
            if (pos < tokens.length) {
                closingBracket = tokens[pos];
            } else {
                throw new IllegalStateException("Unexpected end of expression");
            }
            if (pos < tokens.length && closingBracket.equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }
        pos++;
        // в противном случае токен должен быть числом
        return Double.parseDouble(String.valueOf(next));
    }
}
