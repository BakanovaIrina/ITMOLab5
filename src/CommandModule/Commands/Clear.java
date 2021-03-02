package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда clear - очищает коллекцию
 */
public class Clear extends Command {

    @Override
    public void writeInfo() {
        System.out.println("clear : очистить коллекцию");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager,
                         AbstractCommandManager commandManager, AbstractCollectionManager collectionManager) {
        collectionManager.clear();
    }
}
