package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

/**
 * Команда add_if_min
 */
public class AddIfMin extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public AddIfMin(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoAddIfMinMessage());
    }
    @Override
    public void execute() {
        commandReceiver.addIfMin();
    }

}
