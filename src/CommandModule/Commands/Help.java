package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.*;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда help - вывести справку по доступным командам
 */
public class Help extends Command {

    @Override
    public void writeInfo() {
        System.out.println("help : вывести справку по доступным командам");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        commandManager.getMap().forEach((name, command) -> {command.writeInfo();});
    }
}
