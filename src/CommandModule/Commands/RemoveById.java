package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import CommandModule.CommandWithInputValue;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда remove_by_id - удалить элемент коллекции по его id
 */
public class RemoveById extends Command implements CommandWithInputValue {
    /**
     * Значение id элемента, который надо удалить
     */
    String value;
    @Override
    public void writeInfo() {
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        int id;
        try {
            id = Integer.parseInt(value);
            collectionManager.removeById(consoleManager, id);
        }catch (NumberFormatException e){
            System.out.println("Вы ввели неподходящее значение в поле id");
        }
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
