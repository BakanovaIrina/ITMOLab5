package CommandModule.Commands;

import CollectionModule.AbstractCollectionManager;
import CommandModule.AbstractCommandManager;
import CommandModule.Command;
import CommandModule.CommandWithInputValue;
import ConsoleModule.AbstractConsoleManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Команда execute_script - вызывает исполнения скрипта из файла
 */
public class ExecuteScript extends Command implements CommandWithInputValue {

    /**
     * Поле введенного аргумента (в данном случае имени исполняемого скрипта)
     */
    private String value;

    /**
     * Поле, в котором находятся все раннее вызываемые скрипты
     */
    private static ArrayList<String> lastScripts;

    /**
     * Конструктор
     */
    public ExecuteScript(){
        lastScripts = new ArrayList<>();
    }

    @Override
    public void writeInfo() {
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
    }

    @Override
    public void execute(AbstractConsoleManager consoleManager, AbstractCommandManager commandManager,
                         AbstractCollectionManager collectionManager) {
        try {
            if(!lastScripts.contains(value)){
                lastScripts.add(value);
                consoleManager.executeScript(commandManager, collectionManager, value);
            }
            else {
                System.out.println("Была найдена попытка зациклить программу! Выполнение скрипта было приостановлено");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
