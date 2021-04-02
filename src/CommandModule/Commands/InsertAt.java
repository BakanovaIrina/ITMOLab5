package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import CommandModule.CommandWithInputValue;
import MessengerModule.Messenger;

/**
 * Команда insert_at
 */
public class InsertAt extends Command implements CommandWithInputValue {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Значение индекса
     */
    int value;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public InsertAt(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoInsertAtMessage());
    }

    @Override
    public void execute() {
        commandReceiver.insertAt(value);
    }


    @Override
    public void setValue(String value) throws NumberFormatException {
        this.value = Integer.parseInt(value);
    }
}
