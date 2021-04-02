package CommandModule;

import ExceptionModule.NoArgumentException;
import ExceptionModule.NoSuchCommandException;

/**
 * Класс CommandInvoker
 */
public class CommandInvoker implements CommandInvokerActions {

    /**
     * Менеджер для работы с командами
     */
    private CommandManagerActions commandManager;

    /**
     * Конструктор
     * @param commandManager - менеджер для работы с командами
     */
    public CommandInvoker(CommandManagerActions commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void invokeCommand(String[] command) throws NoSuchCommandException, NoArgumentException {
        Command command1 = commandManager.convertToCommand(command[0]);
        if (command1 instanceof CommandWithInputValue){
            if (command.length != 2 || command[1] == "" || command[1] == null){
                throw new NoArgumentException();
            }
            setValue(command[1],(CommandWithInputValue) command1);
        }
        command1.execute();
    }

    @Override
    public void setValue(String value, CommandWithInputValue command) {
        command.setValue(value);
    }

}
