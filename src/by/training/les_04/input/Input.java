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
    public static String[] expressionInputByScanner() {
        /*String str;

        Scanner input = new Scanner(System.in);
        str = input.nextLine();

        Printer.print(str);

        return str;*/
        Scanner input = new Scanner(System.in);

        int n = 0;
        String [] str = new String[n];
        str[n] = input.nextLine();

        for (int i = 0; i < str.length; i++) {
            n++;
        }
        System.out.print(n);
        System.out.print(str);

        return str;
    }
}
