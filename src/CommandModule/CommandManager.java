package CommandModule;

import CollectionModule.AbstractCollectionManager;
import ConsoleModule.AbstractConsoleManager;

import java.util.HashMap;

/**
 * Класс, осуществляющий вызов команды, заранее разрешенной (т.е. находящейся в карте
 * доступных команд)
 * Нужен для осуществления комманды
 */

public class CommandManager extends AbstractCommandManager{

    /**
     * Конструктор
     * @param map - карта всех доступных команд
     */
    public CommandManager(HashMap<String, Command> map){
        super(map);
    }

    @Override
    public Command convertToCommand(String commandName) {
        if (getMap().containsKey(commandName)){
            return getMap().get(commandName);
        }
        else if (getMapCommandsWithInputValue().containsKey(commandName)){
            return getMapCommandsWithInputValue().get(commandName);
        }
        return null;
    }

    @Override
    public void execute(String commandName, AbstractConsoleManager consoleManager,
                        AbstractCommandManager commandManager, AbstractCollectionManager collectionManager) {
        Command command;
        try {
            commandName = commandName.toLowerCase();
        }
        catch (NullPointerException e){
            System.out.println("Будет выполнен выход из программы");
            System.exit(0);
        }
        String[] commandNames = commandName.split("\t| ");
        for (int i = 0; i < commandNames.length; i++) {
            command = convertToCommand(commandNames[i]);
            if (command instanceof CommandWithInputValue) {
                for (int j = i + 1; j < commandNames.length; j++){
                    if (commandNames[j].trim().length() != 0)
                    ((CommandWithInputValue) command).setValue(commandNames[j]);
                }
                command.execute(consoleManager, commandManager, collectionManager);
                return;
            } else if (command != null) {
                command.execute(consoleManager, commandManager, collectionManager);
                return;
            }
        }
        System.out.println("Вы не ввели команду или нам она не известна. Попробуйте еще!");
    }
}
