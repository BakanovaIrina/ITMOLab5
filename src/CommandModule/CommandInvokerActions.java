package CommandModule;

import ExceptionModule.NoArgumentException;
import ExceptionModule.NoSuchCommandException;

/**
 * Интерфейс CommandInvoker
 */
public interface CommandInvokerActions {

    /**
     * Метод, заставляющий команду исполняться
     * @param command - массив из введенных значений
     * @throws NoSuchCommandException - бросается, если такой команды не существует
     * @throws NoArgumentException - бросается, если команда не была введена
     */
    void invokeCommand(String[] command) throws NoSuchCommandException, NoArgumentException;

    /**
     * Метод, вводящий значение команды со значением
     * @param value - значение
     * @param command - команда, которой нудно значение
     */
    void setValue(String value, CommandWithInputValue command);
}
