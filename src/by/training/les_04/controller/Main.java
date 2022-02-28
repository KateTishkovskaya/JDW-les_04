package by.training.les_04.controller;

import by.training.les_04.input.Input;
import by.training.les_04.logic.LexAnalyze;
import by.training.les_04.logic.Lexeme;
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

        //лексический разбор выражения
        List<Lexeme> lexemes = LexAnalyze.lexemeBreaking(strExpression);

        //создаём массив строк из полученного списка
        String[] tokens = LexAnalyze.listToArray(lexemes);

        //делаем синтаксический анализ выражения
        double rez = SyntacticAnalyze.parse(tokens);

        Printer.print(rez);
    }
}