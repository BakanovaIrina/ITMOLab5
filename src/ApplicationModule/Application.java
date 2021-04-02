package ApplicationModule;

import CollectionModule.*;
import CollectionModule.SpaceMarineCreation.*;
import CommandModule.*;
import ExceptionModule.*;
import InputOutputModule.*;
import InputOutputModule.ConsoleModule.*;
import InputOutputModule.FileModule.*;
import InputOutputModule.ScriptModule.*;
import MessengerModule.*;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс, реализующий выполнение консольного приложения
 */
public class Application implements ApplicationAction{

    /**
     * Поле, показывающиее, выполняется ли программа
     */
    private boolean isRunning;

    /**
     * Менеджер ввода
     */
    private InputManagerActions inputManager;

    /**
     * Менеджер команд
     */
    private CommandManagerActions commandManager;

    /**
     * Менеджер колекции
     */
    private CollectionManager collectionManager;

    /**
     * Менеджер для работы с файлами
     */
    private FileManagerActions fileManager;

    /**
     * Мессенжжер для вывода сообщений в консоль
     */
    private Messenger messenger;

    /**
     * Конвертер даты
     */
    private DateConverter dateConverter;

    /**
     * Конструктор
     */
    public Application(){
        isRunning = true;
    }

    @Override
    public void prepare(String[] fileNames) {

        InputConverter inputConverter = new InputConverter();
        this.dateConverter = new DateConverter(new SimpleDateFormat("yyyy-mm-dd"));
        inputManager = new ConsoleManager(new SpaceMarineCreator(), inputConverter, new ConsoleReader());

        inputLanguage();

        if (fileNames.length == 0){
            messenger.printErrorMessage(messenger.getNoInputArgs("file.csv"));
            fileNames = new String[] {"file.csv"};
        }

        commandManager = new CommandManager(new HashMap());
        fileManager = new FileManager(new FileReader(), new FileWriter(fileNames[0]),
                new Parser(new SpaceMarineCreator(new SpaceMarineValidator(), new GeneratorId()),
                        dateConverter), new RussianMessenger(dateConverter));

        collectionManager = new CollectionManager(fileManager);


        for (String fileName: fileNames) {
            try {
                ArrayList list = fileManager.getCollectionFromFile(fileName);
                collectionManager.addElements(list);
            } catch (FileNotFoundException | UncorrectedNullException | UncorrectedFileException | NullPointerException e) {
                messenger.printErrorMessage(messenger.getUncorrectedFile());
            }
        }
    }

    @Override
    public void inputLanguage() {
        System.out.println("What language do you want to continue in? (Русский, English)");
        String language = null;
        if (inputManager instanceof ConsoleManagerActions){
            language = ((ConsoleManagerActions) inputManager).readLanguage();
        }
        if (language == "english"){
            messenger = new EnglishMessenger(dateConverter);
        }
        else {
            if (language.equals("русский")) {
                messenger = new RussianMessenger(dateConverter);
            } else {
                messenger = new EnglishMessenger(dateConverter);
            }
        }
        messenger.printMessage(messenger.getHelloMessage());
    }

    public void run(){
        CommandReceiver commandReceiver = new CommandReceiver(this, collectionManager, commandManager,
                inputManager,  messenger);
        CommandInvoker commandInvoker = new CommandInvoker(commandManager);
        commandManager.initCommands(commandReceiver);
        while (isRunning){
            String[] commandName = inputManager.readCommand();
            try {
                commandInvoker.invokeCommand(commandName);
            } catch (NoSuchCommandException e) {
                messenger.printErrorMessage(messenger.getNoSuchCommandMessage());
            } catch (NoArgumentException e) {
                messenger.printErrorMessage(messenger.getNoInputCommandValue());
            }
        }
    }

    @Override
    public void runFromFile(String fileName) {
        ScriptManager scriptManager;
        CommandInvoker commandInvoker;
        try {
            scriptManager = new ScriptManager(new ScriptReader(fileManager.getInputStreamForScript(fileName)),
                    new InputConverter(), new SpaceMarineCreator());
            commandInvoker = new CommandInvoker(new CommandManager(new CommandReceiver(this,
                    collectionManager, commandManager, scriptManager, messenger)));
        } catch (FileNotFoundException | UncorrectedNullException | UncorrectedFileException e) {
            messenger.printErrorMessage(messenger.getUncorrectedFile());
            return;
        }

        while (scriptManager.isReady()){
            try {
                String[] commands = scriptManager.readCommand();
                messenger.printMessage("> " + commands[0]);
                commandInvoker.invokeCommand(commands);
            } catch (NoSuchCommandException e) {
                messenger.printErrorMessage(messenger.getNoSuchCommandMessage());
            } catch (NoArgumentException e) {
                messenger.printErrorMessage(messenger.getNoInputCommandValue());
            }
        }
    }

    @Override
    public void exit() {
        isRunning = false;
    }

}
