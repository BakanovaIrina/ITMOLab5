package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда show - вывести все элементы коллекции
 */
public class Show extends Command {
    @Override
    public void writeInfo() {
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        collectionManager.show();
    }
}
