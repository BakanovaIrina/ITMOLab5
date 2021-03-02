import CollectionModule.CollectionManager;
import CommandModule.Command;
import CommandModule.CommandManager;
import CommandModule.Commands.*;
import ConsoleModule.ConsoleCommandReader;
import ConsoleModule.ConsoleFieldReader;
import ConsoleModule.ConsoleFileReader;
import ConsoleModule.ConsoleManager;

import java.util.HashMap;

/**
 * Main-class
 * @author Ирина Баканова
 * @version 1.0
 */

public class Main {
    public static String fileName;
    /**
     * Метод инициализирует основные Менеджеры (классы для работы с конкретным модулем)
     * и ридеры. Так же передает им аргументы командной строки
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            fileName = args[0];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Не были введены аргументы командной строки. Имя файла будет заменено на \"Text.csv\"");
            fileName = "file.csv";
        }
        HashMap<String, Command> map = new HashMap<>();
        initCommands(map);

        CommandManager commandManager = new CommandManager(map);
        CollectionManager collectionManager = new CollectionManager(fileName);

        ConsoleCommandReader commandReader = new ConsoleCommandReader();
        ConsoleFieldReader consoleFieldReader = new ConsoleFieldReader();
        ConsoleFileReader consoleFileReader = new ConsoleFileReader();

        ConsoleManager consoleManager = new ConsoleManager(commandReader, consoleFieldReader, consoleFileReader);

        consoleManager.loadCollection(collectionManager, fileName);
        System.out.println("Вы можете начать работать с коллекцией. Для справки выведите команду \"help\"");

        while (true){
            consoleManager.takeCommand(commandManager, collectionManager);
        }
    }

    /**
     * Метод, инициализирющий карту команд
     * @param map объект, который инициализируется
     * @return инициализированную карту
     */
    private static HashMap<String, Command> initCommands(HashMap<String, Command> map){
        map.put("help", new Help());
        map.put("info", new Info());
        map.put("show", new Show());
        map.put("add", new Add());
        map.put("update id", new UpdateId());
        map.put("remove_by_id id", new RemoveById());
        map.put("clear", new Clear());
        map.put("save", new Save());
        map.put("execute_script file_name", new ExecuteScript());
        map.put("exit", new Exit());
        map.put("insert_at index", new InsertAt());
        map.put("add_if_min", new AddIfMin());
        map.put("reorder", new Reorder());
        map.put("sum_of_health", new SumOfHealth());
        map.put("average_of_health", new AverageOfHealth());
        map.put("group_counting_by_chapter", new GroupCountingByChapter());
        return map;
    }
    }
