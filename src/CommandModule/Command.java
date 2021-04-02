package CommandModule;

import MessengerModule.Messenger;

/**
 * Класс-предок всех команд
 */
public abstract class Command {

    /**
     * Метод, исполняющий команду
     */
    public abstract void execute();

    /**
     * Метод, выводящий информацию о данной команде
     * @param messenger - мессенджер для вывода
     */
    public abstract void writeInfo(Messenger messenger);
}
