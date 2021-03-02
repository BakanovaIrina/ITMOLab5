package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда save - сохранить коллекцию в файл
 */
public class Save extends Command {
    @Override
    public void writeInfo() {
        System.out.println("save : сохранить коллекцию в файл");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                        AbstractCollectionManager collectionManager) {
        collectionManager.save();
        System.out.println("Вы сохранили данную коллекцию в файл");
    }
}
