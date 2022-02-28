package by.training.les_04.input;

import by.training.les_04.view.Printer;

import java.util.Scanner;

/**
 * class Input - отвечает за ввод данных
 *
 * @author K.P.Tishkovskaya
 * @version 1.1 17.02.2022
 */
public class Input {
    /**
     * метод, отвечающий за ввод выражения с клавиатуры
     * @return str - выражение, введённое пользователем
     */
    @SuppressWarnings(value = "unchecked")
    public static String expressionInputByScanner(String stringInput) {
        String str;

        Scanner input = new Scanner(System.in);
        Printer.print(stringInput);

        str = input.nextLine();

        return str;
    }
}
