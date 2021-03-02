package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда reorder - отсортировывает колекцию в обратном порядке
 */
public class Reorder extends Command {
    @Override
    public void writeInfo() {
        System.out.println("reorder : отсортировать коллекцию в порядке, обратном нынешнему");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager, AbstractCollectionManager collectionManager) {
        collectionManager.reorder();
    }
}
