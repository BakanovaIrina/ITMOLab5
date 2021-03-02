package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда add - добавляет новый элемент в коллекцию (ввод пользователя)
 */
public class Add extends Command {

    @Override
    public void writeInfo() {
        System.out.println("add {element}: добавить новый элемент в коллекцию");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        collectionManager.add(consoleManager);
    }

}
