package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

/**
 * Команда clear - очищает коллекцию
 */
public class Clear extends Command {

    /**
     * Исполнитель команды
     */
    CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Clear(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoClearMessage());
    }

    @Override
    public void execute() {
        commandReceiver.clear();
    }
}
