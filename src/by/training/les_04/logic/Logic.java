package by.training.les_04.logic;

import by.training.les_04.view.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * class Logic - отвечает за логику программы
 *
 * @author K.P.Tishkovskaya
 * @version 1.1 17.02.2022
 */
public class Logic {

    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MULTIPLICATION, OP_DIVISION,
        NUMBER,
        END_OF_LINE
    }


    public static class Lexeme {
        LexemeType type;
        String value;
        int pos;

        public List<Lexeme> lexemes;

        public Lexeme(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }



        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }

        public Lexeme(LexemeType type, String value) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }


    public static List<Lexeme> lexemeAnalyze(String strExpression) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;

        while(pos < strExpression.length()) {
            char c = strExpression.charAt(pos);
            switch (c) {
                case '(' :
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')' :
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+' :
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-' :
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*' :
                    lexemes.add(new Lexeme(LexemeType.OP_MULTIPLICATION, c));
                    pos++;
                    continue;
                case '/' :
                    lexemes.add(new Lexeme(LexemeType.OP_DIVISION, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c > '0') {
                        StringBuilder strBuilder = new StringBuilder();
                        do {
                            strBuilder.append(c);
                            pos++;
                            if (pos >= strExpression.length()) {
                                break;
                            }
                            c = strExpression.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, strBuilder.toString()));
                    } else {
                        if (c != ' ') {
                            Printer.print("Вы ввели выражение неправильно");
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.END_OF_LINE, ""));
        return lexemes;
    }

    public static int expression(Lexeme lexemes) {
        int value = term (lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexemes.type){
                case OP_PLUS :
                    value += term(lexemes);
                    break;
                case OP_MINUS:
                    value -= term(lexemes);
                    break;
                default:
                    Printer.print("Вы ввели выражение неверно");
            }
        }
    }

    public static int term(Lexeme lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexemes.type){
                case OP_MULTIPLICATION:
                    value *= factor(lexemes);
                    break;
                case OP_DIVISION:
                    value /= factor(lexemes);
                    break;
                default:
                    Printer.print("Вы ввели выражение неверно");
            }
        }
    }

    public static int factor(Lexeme lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexemes.type) {
            case NUMBER:
                return Integer.parseInt(lexemes.value);
            case LEFT_BRACKET:
                lexeme = lexemes.next();
                int value = expression(lexemes);
                return value;
            default:
                Printer.print("--------");
        }
        return 0;
    }
}
