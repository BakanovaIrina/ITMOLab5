package InputOutputModule.FileModule;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Интерфейс, описывающий действия для записи в файл
 */
public interface FileWriterActions {

    /**
     * Метод, записывающий строчку в данном формате в файл
     * @param spaceMarine - строчка
     * @throws FileNotFoundException - бросается, если файл не найден
     * @throws UnsupportedEncodingException - бросается, если кодировка не корректна
     */
    void write(String spaceMarine) throws FileNotFoundException, UnsupportedEncodingException;
}
