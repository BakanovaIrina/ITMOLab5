package CommandModule.Commands;

import CommandModule.*;
import MessengerModule.Messenger;

/**
 * Команда help - вывести справку по доступным командам
 */
public class Help extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Help(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoHelpMessage());
    }

    @Override
    public void execute() {
        commandReceiver.help();
    }
}
