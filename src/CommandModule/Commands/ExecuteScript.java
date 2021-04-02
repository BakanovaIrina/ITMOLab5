package CommandModule.Commands;

import CommandModule.Command;
import CommandModule.CommandReceiverActions;
import CommandModule.CommandWithInputValue;
import MessengerModule.Messenger;

/**
 * Команда execute_script
 */
public class ExecuteScript extends Command implements CommandWithInputValue {
    /**
     * Исполнитель команды
     */
    private CommandReceiverActions commandReceiver;

    /**
     * Имя исполняемого файла
     */
    private String value;

    /**
     * Конструктор
     * @param commandReceiver - исполнитель команды
     */
    public ExecuteScript(CommandReceiverActions commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void writeInfo(Messenger messenger) {
        messenger.printMessage(messenger.getInfoExecuteScriptMessage());
    }

    @Override
    public void execute() {
        commandReceiver.executeScript(value);
    }

    @Override
    public void setValue(String value) throws NumberFormatException {
        this.value = value;
    }
}
