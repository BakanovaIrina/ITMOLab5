package ConsoleModule;

import java.io.IOException;

/**
 * Интерфейс, описывающий поведение класса, который считывает поля для добавления нового элемента в коллекцию
 */
public interface FieldReader {

    /**
     * Метод, осуществляющий чтение полей типа int
     * @return int
     * @throws IOException
     */
    int readInt() throws IOException;

    /**
     * Метод, осуществляющий чтение полей типа float
     * @return float
     * @throws IOException
     */
    float readFloat() throws IOException;

    /**
     * Метод, осуществляющий чтение полей типа double
     * @return double
     * @throws IOException
     */
    double readDouble() throws IOException;

    /**
     * Метод, осуществляющий чтение полей типа String
     * @return String
     * @throws IOException
     */
    String readString() throws IOException;
}
