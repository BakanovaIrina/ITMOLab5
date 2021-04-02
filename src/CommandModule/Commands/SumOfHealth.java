package CommandModule.Commands;

import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.CollectionManagerActions;
import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Команда sum_of_health - выводит сумму здоровья всех элементов
 */
public class SumOfHealth extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public SumOfHealth(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoSumOfHealthMessage());
    }

    @Override
    public void execute() {
        commandReceiver.sumOfHealth();
    }
}
