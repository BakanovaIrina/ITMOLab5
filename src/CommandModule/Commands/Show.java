package CommandModule.Commands;

import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.CollectionManagerActions;
import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

import java.util.ArrayList;

/**
 * Команда show - вывести все элементы коллекции
 */
public class Show extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Show(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoShowMessage());
    }

    @Override
    public void execute() {
        commandReceiver.show();
    }
}
