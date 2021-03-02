package ConsoleModule;

import java.io.BufferedReader;

/**
 * Класс, осуществляющий чтение полей из консоли
 */
public abstract class AbstractConsoleFieldReader implements FieldReader {

    /**
     * BufferedReader для ввода полей
     */
    private final BufferedReader reader;

    /**
     * Конструктор
     * @param reader
     */
    AbstractConsoleFieldReader(BufferedReader reader){
        this.reader = reader;
    }

    public BufferedReader getReader() {
        return reader;
    }
}
