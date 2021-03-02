package CollectionModule;

import CollectionModule.BaseClass.SpaceMarine;
import ConsoleModule.AbstractConsoleManager;

/**
 * Интерфейс, описывающий исполнение основных команд
 */
public interface CollectionManagerDoings {
    /**
     * Метод команды info
     */
    void info();

    /**
     * Метод команды show
     */
    void show();

    /**
     * Метод команды add
     */
    void add(AbstractConsoleManager consoleManager);

    /**
     * Метод команды clear
     */
    void clear();

    /**
     * Метод команды sum_of_health
     */
    void sumOfHealth();

    /**
     * Метод команды average_of_health
     */
    void averageOfHealth();

    /**
     * Метод, добавляющий объект SpaceMarine в коллекцию
     */
    void addToCollection(SpaceMarine spaceMarine);

    /**
     * Метод команды remove_by_id
     */
    void removeById(AbstractConsoleManager consoleManager, int id);

    /**
     * Метод команды update
     */
    void updateId(AbstractConsoleManager consoleManager);

    /**
     * Метод команды insert
     */
    void insertAt(AbstractConsoleManager consoleManager, int index);

    /**
     * Метод команды add_if_min
     */
    void addIfMin(AbstractConsoleManager consoleManager);

    /**
     * Метод команды reorder
     */
    void reorder();

    /**
     * Метод команды group_counting_by_chapter
     */
    void groupCountingByChapter();

    /**
     * Метод команды save
     */
    void save();
}
