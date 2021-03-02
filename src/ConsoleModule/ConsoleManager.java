package ConsoleModule;

import CollectionModule.AbstractCollectionManager;
import CollectionModule.BaseClass.AstartesCategory;
import CollectionModule.BaseClass.MeleeWeapon;
import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.BaseClass.Weapon;
import CollectionModule.Checker;
import CollectionModule.Parser;
import CommandModule.AbstractCommandManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Класс, осуществляющий взаимодействие с ридерами (команд, полей и файла), проверяющий правильность
 * введенных примитивных типов и некоторых enum
 */
public class ConsoleManager extends AbstractConsoleManager {

    /**
     * Конструктор класса
     * @param commandReader - читатель команд
     * @param fieldReader - читатель полей
     * @param fileReader - читатель файлов
     */
    public ConsoleManager(CommandReader commandReader, FieldReader fieldReader, FileReader fileReader){
        super(commandReader, fieldReader, fileReader);
    }

    @Override
    public void takeCommand(AbstractCommandManager commandManager,
                            AbstractCollectionManager collectionManager) {
        try{
            execute(getCommandReader().read(), commandManager, collectionManager);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод осуществляет игнорирование регистров при вводе enum
     * @param name - имя enum
     * @return - возвращает enum в верхнем регистре
     */
    private String toEnumForm(String name){
        return name.toUpperCase();
    }

    @Override
    public void execute(String commandName,
                        AbstractCommandManager commandManager, AbstractCollectionManager collectionManager) {
        commandManager.execute(commandName, this, commandManager, collectionManager);
    }

    @Override
    public int acceptInt() {
        boolean isIntroduced = false;
        int i = 0;
        while (!isIntroduced){
            try {
                i = getFieldReader().readInt();
                isIntroduced = true;
            }
            catch (IOException e){
                e.printStackTrace();
            }
            catch (NumberFormatException e){
                System.out.println("Введен неверный аргумент, попробуйте еще раз:");
            }
        }
        return i;
    }

    @Override
    public float acceptFloat() {
        boolean isIntroduced = false;
        float i = 0;
        while (!isIntroduced){
            try {
                i = getFieldReader().readFloat();
                isIntroduced = true;
            }
            catch (NumberFormatException e){
                System.out.println("Введен неверный аргумент, попробуйте еще раз:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override
    public double acceptDouble() {
        boolean isIntroduced = false;
        double i = 0;
        while (!isIntroduced){
            try {
                i = getFieldReader().readDouble();
                isIntroduced = true;
            }
            catch (NumberFormatException e){
                System.out.println("Введен неверный аргумент, попробуйте еще раз:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override
    public String acceptString() {
        try {
            return getFieldReader().readString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AstartesCategory acceptCategory(){
        boolean isInterruped = false;
        AstartesCategory category = null;
        while (!isInterruped){
            try {
                category = AstartesCategory.valueOf(toEnumForm(getFieldReader().readString()));
                isInterruped = true;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e){
                System.out.println("Мы не знаем такую категорию. Повторите ввод:");
            }
        }
        return category;
    }

    @Override
    public Weapon acceptWeapon(){
        boolean isInterruped = false;
        Weapon weapon = null;
        while (!isInterruped){
            try {
                weapon = Weapon.valueOf(toEnumForm(getFieldReader().readString()));
                isInterruped = true;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e){
                System.out.println("Мы не знаем такое оружие. Повторите ввод:");
            }
        }
        return weapon;
    }

    @Override
    public MeleeWeapon acceptMeleeWeapon(){
        boolean isInterruped = false;
        MeleeWeapon weapon = null;
        while (!isInterruped){
            try {
                weapon = MeleeWeapon.valueOf(toEnumForm(getFieldReader().readString()));
                isInterruped = true;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e){
                System.out.println("Мы не знаем такое оружие ближнего боя. Повторите ввод:");
            }
        }
        return weapon;
    }

    @Override
    public void executeScript(AbstractCommandManager commandManager,
                              AbstractCollectionManager collectionManager, String fileName) {
        InputStreamReader inputStreamReader = getFileReader().openFile(fileName);
        if (Checker.checkNull(inputStreamReader)){
            Scanner input = new Scanner(inputStreamReader);
            while (input.hasNextLine()){
                String commandName = input.nextLine();
                System.out.println("> " + commandName);
                execute(commandName, commandManager, collectionManager);
            }
        }
    }

    @Override
    public void loadCollection(AbstractCollectionManager collectionManager, String fileName) {
        InputStreamReader inputStreamReader = getFileReader().openFile(fileName);
        if (Checker.checkNull(inputStreamReader)){
            Scanner input = new Scanner(inputStreamReader);
            while (input.hasNextLine()){
                SpaceMarine spaceMarine = Parser.toSpaceMarine(input.nextLine(), collectionManager.dateFormat);
                collectionManager.addToCollection(spaceMarine);
            }
        }
    }

}
