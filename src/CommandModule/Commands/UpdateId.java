package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import CommandModule.CommandWithInputValue;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда update - обновляет значение id элемента
 */
public class UpdateId extends Command implements CommandWithInputValue {
    /**
     * Значение поля id
     */
    String value;
    @Override
    public void writeInfo() {
        System.out.println("update id {element} : обновить значение id элемента коллекции, id которого равен заданному");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager, AbstractCollectionManager collectionManager) {
        collectionManager.updateId(consoleManager);
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
