package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CollectionModule.Checker;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import CommandModule.CommandWithInputValue;
import ConsoleModule.AbstractConsoleManager;

/**
 * Команда insert_at - добавляет новый элемент в заданную позицию
 */
public class InsertAt extends Command implements CommandWithInputValue{
    /**
     * Поле значения индекса добавляемого элемента
     */
    private String value;

    @Override
    public void writeInfo() {
        System.out.println("insert_at index {element} : добавить новый элемент в заданную позицию");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        try {
            int index = Integer.parseInt(value);
            if (!Checker.checkIndex(index)){
                collectionManager.insertAt(consoleManager, index);
            }
            else {
                System.out.println("Вы ввели неправильное значение индекса");
            }
        }
        catch (NumberFormatException e){
            System.out.println("Вы ввели неправильный индекс, попробуйте еще!");
        }
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
