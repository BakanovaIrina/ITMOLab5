package ConsoleModule;

import java.io.File;
import java.io.InputStreamReader;

/**
 * Интерфейс для класса, осуществляющего чтение из файла
 */
public interface FileReader {

    /**
     * Статический класс для проверки файла
     * @param file - проверяемый файл
     * @return boolean passedCheck - возвращает, прошел ли файл проверку
     */
    boolean fileCheck(File file);

    /**
     * Метод, который открывает файл
     * @param fileName - имя открываемого файла
     * @return - возвращает inputStreamReader
     */
    InputStreamReader openFile(String fileName);

}
