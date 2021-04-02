package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

/**
 * Команда info - выводит информацию о коллекции
 */
public class Info extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Info(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoInfoMessage());
    }

    @Override
    public void execute() {
        commandReceiver.info();
    }
}
