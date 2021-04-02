package InputOutputModule.FileModule;

import java.io.*;

/**
 * Класс, записывающий данные в файл
 */
public class FileWriter implements FileWriterActions {
    /**
     * Имя файла
     */
    String fileName;

    /**
     * Записыватель
     */
    PrintWriter printWriter;

    /**
     * Конструктор
     * @param fileName - имя файла для записи
     */
    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String spaceMarine) throws FileNotFoundException, UnsupportedEncodingException {
        printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName), "Cp866"));
        printWriter.println(spaceMarine);
    }
}
