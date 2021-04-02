package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import CommandModule.CommandWithInputValue;
import MessengerModule.Messenger;

/**
 * Команда update_id
 */
public class UpdateId extends Command implements CommandWithInputValue {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Значение id
     */
    private int value;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public UpdateId(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoUpdateIdMessage());
    }

    @Override
    public void execute() {
        commandReceiver.updateId(value);
    }

    @Override
    public void setValue(String value) throws NumberFormatException {
        this.value = Integer.parseInt(value);
    }
}
