package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

/**
 * Команда Add
 */
public class Add extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Add(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoAddMessage());
    }
    @Override
    public void execute() {
        commandReceiver.add();
    }

}
