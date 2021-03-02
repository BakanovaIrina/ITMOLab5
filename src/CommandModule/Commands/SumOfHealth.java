package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда sum_of_health - выводит сумму здоровья всех элементов
 */
public class SumOfHealth extends Command {
    @Override
    public void writeInfo() {
        System.out.println("sum_of_health : вывести сумму значений поля health для всех элементов коллекции");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        collectionManager.sumOfHealth();
    }
}
