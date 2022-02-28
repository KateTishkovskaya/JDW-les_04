package by.training.les_04.controller;

import by.training.les_04.logic.Logic;

import java.util.ArrayList;
import java.util.List;

/**
 * classs Main - класс тестирования программы
 *
 * @author K.P.Tishkovskaya
 * @version 1.1 17.02.2022
 */
public class Main {
    public static void main(String[] args) {
        //String [] str = Input.expressionInputByScanner();
        String strEx = "23+34 - 34";
        List<Logic.Lexeme> lexemes = Logic.lexemeAnalyze(strEx);

        System.out.println();
        System.out.println(lexemes);

        Logic.Lexeme qwe = new Logic.Lexeme(lexemes);
        System.out.println(Logic.expression(qwe));
    }
}