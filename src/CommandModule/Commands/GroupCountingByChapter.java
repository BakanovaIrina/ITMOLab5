package CommandModule.Commands;

import CollectionModule.CollectionManagerActions;
import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Команда group_counting_by_chapter - группирует элементы по главам
 */
public class GroupCountingByChapter extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public GroupCountingByChapter(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoGroupCountingByChapterMessage());
    }

    @Override
    public void execute() {
        commandReceiver.groupCountingByChapter();
    }
}
