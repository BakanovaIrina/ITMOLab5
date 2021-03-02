package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда Exit - завершить работу программы
 */
public class Exit extends Command {
    @Override
    public void writeInfo() {
        System.out.println("exit : завершить программу (без сохранения в файл)");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        System.exit(0);
    }

}
