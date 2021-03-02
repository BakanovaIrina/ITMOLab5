package ConsoleModule;

import java.io.BufferedReader;

/**
 * Класс-предок читателя команд
 */

public abstract class AbstractCommandReader implements CommandReader {
    /**
     * BufferedReader для чтения пользовательского ввода (из консоли)
     */
    private final BufferedReader reader;

    /**
     * @param reader - ссылка на поле reader
     */

    AbstractCommandReader(BufferedReader reader){
        this.reader = reader;
    }

    /**
     * @return reader
     */

    public BufferedReader getReader() {
        return reader;
    }

}
