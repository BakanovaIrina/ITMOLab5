package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

/**
 * Команда reorder - отсортировывает колекцию в обратном порядке
 */
public class Reorder extends Command {

    /**
     * Исполнитель команды
     */
    CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Reorder(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoReorderMessage());
    }

    @Override
    public void execute() {
        commandReceiver.reorder();
    }
}
