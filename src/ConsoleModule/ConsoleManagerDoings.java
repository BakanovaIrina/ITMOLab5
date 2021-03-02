package ConsoleModule;

import CollectionModule.AbstractCollectionManager;
import CollectionModule.BaseClass.AstartesCategory;
import CollectionModule.BaseClass.MeleeWeapon;
import CollectionModule.BaseClass.Weapon;
import CommandModule.AbstractCommandManager;

import java.io.IOException;

/**
 * Интерфейс, прописывающий действия класса ConsoleManager
 */
public interface ConsoleManagerDoings {
    /**
     * Метод, принимающий введенную пользователем команду
     * @param commandManager - класс, содержащий в себе список всех команд
     * @param collectionManager - класс, осуществляющий работу с коллекцией
     */
    void takeCommand(AbstractCommandManager commandManager, AbstractCollectionManager collectionManager);

    /**
     * Метод, передающий классу CommandManager поля
     * @param commandName - введеное пользователем имя команды, которую нужно осуществить
     * @param commandManager - класс, содержащий в себе список всех команд
     * @param collectionManager - - класс, осуществляющий работу с коллекцией
     */
    void execute(String commandName, AbstractCommandManager commandManager,
                 AbstractCollectionManager collectionManager);

    /**
     * Метод для ввода полей определенных значений
     * @return int - возвращает значение int
     */
    int acceptInt();

    /**
     * Метод для ввода полей определенных значений
     * @return float - возвращает значение float
     */
    float acceptFloat();

    /**
     * Метод для ввода полей определенных значений
     * @return double - возвращает значение double
     */
    double acceptDouble();

    /**
     * Метод для ввода полей определенных значений
     * @return String - возвращает значение строки
     */
    String acceptString();

    /**
     * Метод для ввода полей определенных значений
     * @return AstartesCategory - возвращает значение AstartesCategory
     */
    AstartesCategory acceptCategory();

    /**
     * Метод для ввода полей определенных значений
     * @return Weapon - возвращает значение оружия
     */
    Weapon acceptWeapon();

    /**
     * Метод для ввода полей определенных значений
     * @return Weapon - возвращает значение оружия ближнего боя
     */
    MeleeWeapon acceptMeleeWeapon();

    /**
     * Метод, нужный для чтения скрипта
     * @param commandManager - менеджер команд
     * @param collectionManager - менеджер коллекци
     * @throws IOException
     */
    void executeScript(AbstractCommandManager commandManager,
                       AbstractCollectionManager collectionManager, String fileName) throws IOException;

    /**
     * Метод, осуществляющий загрузку классов из файла
     * @param collectionManager - менеджер коллекции
     * @param fileName - имя файла
     */
    void loadCollection(AbstractCollectionManager collectionManager, String fileName);
}
