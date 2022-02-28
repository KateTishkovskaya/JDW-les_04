package by.training.les_04.logic;

import by.training.les_04.view.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * class LexAnalyze - отвечает за разбиение строки на лексемы
 *
 * @author K.P.Tishkovskaya
 * @version 1.1 17.02.2022
 */
public class LexAnalyze {
    public static ArrayList<Lexeme> lexemes = new ArrayList<>();

    /**
     * Метод разбивает полученную строку на лексемы
     * @param strExpression - строка, введённая пользователм
     * @return список лексем
     */
    public static List<Lexeme> lexemeBreaking(String strExpression) {
        int pos = 0;

        while(pos < strExpression.length()) {
            char c = strExpression.charAt(pos);
            switch (c) {
                case '(' :
                case ')' :
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    lexemes.add(new Lexeme(c));
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
                        lexemes.add(new Lexeme(strBuilder.toString()));
                    } else {
                        if (c != ' ') {
                            Printer.print("Вы ввели выражение неправильно");
                        }
                        pos++;
                    }
            }
        }
        return lexemes;
    }

    /**
     * Метод, который преобразует список лексем в массив
     * @param lexemes - список полученных лексем
     * @return массив tokens
     */
    public static String[] listToArray(List<Lexeme> lexemes) {
        String[] tokens;
        tokens = new String[lexemes.size()];

        for (int i=0;i< lexemes.size();i++){
            tokens[i] = String.valueOf(lexemes.get(i).getValue());
        }

        return tokens;
    }
}
