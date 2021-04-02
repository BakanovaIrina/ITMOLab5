package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import CommandModule.CommandWithInputValue;
import MessengerModule.Messenger;

/**
 * Команда remove_by_id - удалить элемент коллекции по его id
 */
public class RemoveById extends Command implements CommandWithInputValue {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Значение id элемента, который надо удалить
     */
    int value;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public RemoveById(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoRemoveByIdMessage());
    }

    @Override
    public void execute() {
        commandReceiver.removeById(value);
    }

    @Override
    public void setValue(String value) throws NumberFormatException {
        this.value = Integer.parseInt(value);
    }
}
