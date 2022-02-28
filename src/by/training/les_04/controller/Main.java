package by.training.les_04.controller;

import by.training.les_04.input.Input;
import by.training.les_04.logic.LexAnalyze;
import by.training.les_04.logic.SyntacticAnalyze;
import by.training.les_04.view.Printer;

import java.util.List;

/**
 * classs Main - класс тестирования программы
 *
 * @author K.P.Tishkovskaya
 * @version 1.1 17.02.2022
 */
public class Main {
    public static void main(String[] args) {
        String strExpression;
        strExpression = Input.expressionInputByScanner("Введите выражение:");

        List<LexAnalyze.Lexeme> lexemes = LexAnalyze.lexemeBreaking(strExpression);

        System.out.println(lexemes);

        LexAnalyze.Lexeme rez = new LexAnalyze.Lexeme(lexemes);
        //Printer.print(factor(rez));
        //System.out.println(Logic.expression(qwe));
    }
}