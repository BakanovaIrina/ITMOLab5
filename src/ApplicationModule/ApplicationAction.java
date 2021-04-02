package ApplicationModule;

/**
 * Интерфейс, описывающий выполнение консольного приложения
 */
public interface ApplicationAction {

    /**
     * Метод для подготовки
     * @param fileNames имя файлов
     */
    void prepare(String[] fileNames);

    /**
     * Исполнение команд в обычном режиме
     */
    void run();

    /**
     * Исполнение команд из файла
     * @param fileName - имя файла
     */
    void runFromFile(String fileName);

    /**
     * Метод для ввода языка
     */
    void inputLanguage();

    /**
     * Метод для замершения исполнения
     */
    void exit();
}
