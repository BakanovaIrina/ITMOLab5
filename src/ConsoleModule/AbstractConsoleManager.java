package ConsoleModule;

/**
 * Абстрактный класс, задающий основное поведения класса для взаимодействия с консолью
 */

public abstract class AbstractConsoleManager implements ConsoleManagerDoings {

    /**
     * Поле класса, читающего ввод команд
     */
    private final CommandReader commandReader;

    /**
     * Поле класса, осуществляющего ввод полей для значений добавляемых элементов
     */
    private final FieldReader fieldReader;


    /**
     * Поле класса, осуществляющего чтение из файла
     */
    private final FileReader fileReader;

    /**
     * Конструктор класса
     * @param commandReader - ридер коанд
     * @param fieldReader - ридер полей
     */
    AbstractConsoleManager(CommandReader commandReader, FieldReader fieldReader, FileReader fileReader){
        this.commandReader = commandReader;
        this.fieldReader = fieldReader;
        this.fileReader = fileReader;
    }

    public CommandReader getCommandReader() {
        return commandReader;
    }

    public FieldReader getFieldReader() {
        return fieldReader;
    }

    public FileReader getFileReader() {
        return fileReader;
    }
}
