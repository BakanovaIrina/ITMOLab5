package MessengerModule;

/**
 * Интерфейс для получения сообщений об ошибках
 */
public interface ExceptionMessages {

    /**
     * Метод для получения сообщения об ошибке (несуществующая команда)
     * @return String message
     */
    String getNoSuchCommandMessage();

    /**
     * Метод для получения сообщения об ошибке (неправильный размер)
     * @return String message
     */
    String getUncorrectedSize();

    /**
     * Метод для получения сообщения об ошибке (некорректно введено поле)
     * @return String message
     */
    String getUncorrectedField();

    /**
     * Метод для получения сообщения об ошибке (неправильный файл)
     * @return String message
     */
    String getUncorrectedFile();

    /**
     * Метод для получения сообщения об ошибке (не введены значения параметров командной строки)
     * @param fileName - имя файла, который будет использоваться
     * @return String message
     */
    String getNoInputArgs(String fileName);

    /**
     * Метод для получения сообщения об ошибке (не введено значение команды)
     * @return String message
     */
    String getNoInputCommandValue();

    /**
     * Метод для получения сообщения об ошибке (некорректный скрипт)
     * @return String message
     */
    String getUncorrectedScript();
}
