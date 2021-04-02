package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import MessengerModule.Messenger;

/**
 * Команда exit
 */
public class Exit extends Command {

    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public Exit(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoExitMessage());
    }

    public void execute(){
        commandReceiver.exit();
    }

}
