package CommandModule.Commands;

import CollectionModule.CollectionManagerActions;
import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

/**
 * Команда save - сохранить коллекцию в файл
 */
public class Save extends Command {

    /**
     * Исполнитель команды
     */
    CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Save(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoSaveMessage());
    }

    @Override
    public void execute() {
        commandReceiver.save();
    }
}
