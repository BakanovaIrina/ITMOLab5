package CommandModule;

/**
 * Интерфейс, описывающий действия CommandReceiver
 */
public interface CommandReceiverActions {

    /**
     * Исполнение команды average_of_health
     */
    void averageOfHealth();

    /**
     * Исполнение команды add
     */
    void add();

    /**
     * Исполнение команды add_if_min
     */
    void addIfMin();

    /**
     * Исполнение команды clear
     */
    void clear();

    /**
     * Исполнение команды exit
     */
    void exit();

    /**
     * Исполнение команды group_counting_by_chapter
     */
    void groupCountingByChapter();

    /**
     * Исполнение команды help
     */
    void help();

    /**
     * Исполнение команды info
     */
    void info();

    /**
     * Исполнение команды reorder
     */
    void reorder();

    /**
     * Исполнение команды save
     */
    void save();

    /**
     * Исполнение команды show
     */
    void show();

    /**
     * Исполнение команды sum_of_health
     */
    void sumOfHealth();

    /**
     * Исполнение команды remove_by_id
     * @param id - id удаляемого элемента
     */
    void removeById(int id);

    /**
     * Исполнение команды update_id
     * @param id - id изменяемого элемента
     */
    void updateId(int id);

    /**
     * Исполнение команды insert_at
     * @param index - индекс, куда нужно поместить элемент
     */
    void insertAt(int index);

    /**
     * Исполнение команды execute_script
     * @param fileName - имя скрипта
     */
    void executeScript(String fileName);
}
