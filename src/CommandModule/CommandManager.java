package CommandModule;

import CommandModule.Commands.*;
import ExceptionModule.NoSuchCommandException;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Класс для работы с командами
 */
public class CommandManager implements CommandManagerActions{

    /**
     * HashMap, содержащее в себе имена и соответствующие команды
     */
    private HashMap<String, Command> commands;

    /**
     * Конструктор
     * @param commands - команды
     */
    public CommandManager(HashMap<String, Command> commands){
        this.commands = commands;
    }

    /**
     * Конструктор
     * @param commandReceiver - необходим для инициализации
     */
    public CommandManager(CommandReceiverActions commandReceiver) {
        commands = new HashMap<>();
        initCommands(commandReceiver);
    }

    @Override
    public void initCommands(CommandReceiverActions commandReceiver) {
        commands.put("exit", new Exit(commandReceiver));
        commands.put("clear", new Clear(commandReceiver));
        commands.put("average_of_health", new AverageOfHealth(commandReceiver));
        commands.put("info", new Info(commandReceiver));
        commands.put("help", new Help(commandReceiver));
        commands.put("reorder", new Reorder(commandReceiver));
        commands.put("show", new Show(commandReceiver));
        commands.put("sum_of_health", new SumOfHealth(commandReceiver));
        commands.put("remove_by_id", new RemoveById(commandReceiver));
        commands.put("update_id", new UpdateId(commandReceiver));
        commands.put("add", new Add(commandReceiver));
        commands.put("add_if_min", new AddIfMin(commandReceiver));
        commands.put("insert_at", new InsertAt(commandReceiver));
        commands.put("execute_script", new ExecuteScript(commandReceiver));
        commands.put("save", new Save(commandReceiver));
        commands.put("group_counting_by_chapter", new GroupCountingByChapter(commandReceiver));
    }

    @Override
    public Stream getStreamOfCommands() {
        return commands.values().stream();
    }

    @Override
    public Command convertToCommand(String commandName) throws  NoSuchCommandException {
        Command command;
        if (commands.containsKey(commandName)) {
            command = commands.get(commandName);
        }
        else {
            throw new NoSuchCommandException();
        }
        return command;
    }

}
