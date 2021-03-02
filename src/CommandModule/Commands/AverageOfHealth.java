package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда average_of_health, выводящая среднее значение поля health всех элементов коллекции
 */
public class AverageOfHealth extends Command {
    @Override
    public void writeInfo() {
        System.out.println("average_of_health : вывести среднее значение поля health для всех элементов коллекции");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        collectionManager.averageOfHealth();
    }
}
