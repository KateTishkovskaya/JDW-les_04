package by.training.les_04.logic;

/**
 * class Lexeme
 *
 * @author K.P.Tishkovskaya 28.02.2022
 * @version 1.1
 */
public class Lexeme {
    String value;

    public Lexeme(Character value) {
        this.value = value.toString();
    }

    public Lexeme(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
