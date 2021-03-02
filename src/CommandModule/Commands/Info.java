package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда info - выводит информацию о коллекции
 */
public class Info extends Command {
    @Override
    public void writeInfo() {
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов)");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        collectionManager.info();
    }
}
