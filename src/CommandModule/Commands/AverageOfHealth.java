package CommandModule.Commands;

import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.CollectionManagerActions;
import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Команда average_of_health, выводящая среднее значение поля health всех элементов коллекции
 */
public class AverageOfHealth extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public AverageOfHealth(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoAverageOfHealthMessage());
    }

    @Override
    public void execute() {
        commandReceiver.averageOfHealth();
    }
}
