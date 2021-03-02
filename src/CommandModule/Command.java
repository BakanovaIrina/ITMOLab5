package CommandModule;

import CollectionModule.AbstractCollectionManager;
import ConsoleModule.AbstractConsoleManager;

/**
 * Класс-предок всех Комманд
 */
public abstract class Command {

    /**
     * Выводит описание действий команды
     */
    public abstract void writeInfo();

    /**
     * Вызывает исполнение определенной команды
     * @param consoleManager - менеджер по работе с консолью
     * @param commandManager - менеджер по работе с командами
     * @param collectionManager - менеджер по работе с коллекцией
     */
    public abstract void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                                  AbstractCollectionManager collectionManager);
}
