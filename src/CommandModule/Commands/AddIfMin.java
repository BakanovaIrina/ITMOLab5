package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда add_if_min - добавляет новый элемент, если тот имеет наименьшее значение
 */
public class AddIfMin extends Command {
    @Override
    public void writeInfo() {
        System.out.println("add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager, AbstractCollectionManager collectionManager) {
        collectionManager.addIfMin(consoleManager);
    }
}
