package ConsoleModule;

import java.io.IOException;

/**
 * Интерфейс, показывающий действия для чтения команд
 */
public interface CommandReader {
    /**
     * Метод для чтения пользовательского ввода
     * @return String - строка - введеная команда
     * @throws IOException
     */
    String read() throws IOException;
}
