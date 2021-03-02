package CommandModule;

import CollectionModule.AbstractCollectionManager;
import ConsoleModule.AbstractConsoleManager;

/**
 * Интерфейс, задающий основные методы для Менеджера команд
 */
public interface CommandManagerDoings {

    /**
     * Метод, конвертирующий введенную пользователем команду (из String в Command)
     * @param commandName - имя команды
     * @return - возвращает введеную команду (в классе Command)
     */
    Command convertToCommand(String commandName);

    /**
     * Вызывает действия в уже реализованном потомке класса Command
     * @param commandName - имя команды
     * @param consoleManager - менеджер по работе с консолью
     * @param commandManager - менеджер по работе с коммандами
     * @param collectionManager - - менеджер по работе с коллекцией
     */
    void execute(String commandName, AbstractConsoleManager consoleManager,
                 AbstractCommandManager commandManager, AbstractCollectionManager collectionManager);
}
