package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда group_counting_by_chapter - группирует элементы по главам
 */
public class GroupCountingByChapter extends Command {
    @Override
    public void writeInfo() {
        System.out.println("group_counting_by_chapter : сгруппировать элементы коллекции по значению поля chapter, вывести количество элементов в каждой группе");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager, AbstractCollectionManager collectionManager) {
        collectionManager.groupCountingByChapter();
    }

}
