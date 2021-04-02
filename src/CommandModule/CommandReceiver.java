package CommandModule;

import ApplicationModule.ApplicationAction;
import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.CollectionManagerActions;
import InputOutputModule.InputManagerActions;
import MessengerModule.Messenger;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс CommandReceiver
 */
public class CommandReceiver implements CommandReceiverActions{
    /**
     * Поле application
     */
    private final ApplicationAction application;

    /**
     * Поле CollectionManager
     */
    private final CollectionManagerActions collectionManager;

    /**
     * Поле CommandManager
     */
    private final CommandManagerActions commandManager;

    /**
     * Поле InputManager
     */
    private final InputManagerActions inputManager;

    /**
     * Поле для вывода сообщений
     */
    private final Messenger messenger;

    /**
     * Статический список всех раннее вызванных команд
     */
    private static final ArrayList<String> lastScripts = new ArrayList<>();

    /**
     * Конструктор
     * @param application - соответствующее поле
     * @param collectionManager - соответствующее поле
     * @param commandManager - соответствующее поле
     * @param inputManager - соответствующее поле
     * @param messenger - соответствующее поле
     */
    public CommandReceiver(ApplicationAction application, CollectionManagerActions collectionManager,
                           CommandManagerActions commandManager, InputManagerActions inputManager,
                           Messenger messenger) {
        this.application = application;
        this.collectionManager = collectionManager;
        this.commandManager = commandManager;
        this.inputManager = inputManager;
        this.messenger = messenger;
    }

    @Override
    public void averageOfHealth() {
        float sum = 0f;
        int size = 0;
        List<Float> healthOfMarine = collectionManager
                .getStream()
                .filter(Objects::nonNull)
                .map(SpaceMarine::getHealth)
                .collect(Collectors.toList());
        for (Float health: healthOfMarine) {
            sum += health;
            size++;
        }

        if(size == 0){
            messenger.printMessage(messenger.getNoElementsInCollection());
        }
        else {
            messenger.printMessage(messenger.getPrintAverageOfHealthMessage(sum/size));
        }
    }

    @Override
    public void add() {
        collectionManager.addElement(inputManager.readSpaceMarine(messenger));
    }

    @Override
    public void addIfMin() {
        Comparator<SpaceMarine> comparator = Comparator.naturalOrder();
        SpaceMarine min = collectionManager.getStream().min(comparator).get();
        SpaceMarine spaceMarine = inputManager.readSpaceMarine(messenger);
        if (min.compareTo(spaceMarine) < 0){
            collectionManager.addElement(spaceMarine);
        }
        else {
            messenger.printMessage(messenger.getIsNotMinMessage());
        }
    }

    @Override
    public void clear() {
        collectionManager.clear();
    }

    @Override
    public void exit() {
        application.exit();
    }

    @Override
    public void groupCountingByChapter() {
        collectionManager.getStream()
                .filter(spaceMarine -> spaceMarine != null)
                .map(spaceMarine -> spaceMarine.getChapter().getName())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> messenger.printMessage(messenger.getSumMarinesInChapterMessage(k, v)));
    }

    @Override
    public void help() {
        commandManager.getStreamOfCommands().forEach(command -> command.writeInfo(messenger));
    }

    @Override
    public void info() {
        messenger.printMessage(messenger.getPrintInfo(collectionManager.getType().getName(),
                collectionManager.getDate(), collectionManager.getSize()));
    }

    @Override
    public void reorder() {
        collectionManager.reorder();
    }

    @Override
    public void save() {
        collectionManager.save();
    }

    @Override
    public void show() {
        collectionManager.getStream().
                filter(spaceMarine -> spaceMarine != null)
                .forEach(spaceMarine -> messenger.printMessage(messenger.getElementMessage(spaceMarine)));
    }

    @Override
    public void sumOfHealth() {
        float sum = 0f;
        List<Float> healthOfMarine = collectionManager
                .getStream()
                .filter(spaceMarine -> spaceMarine != null)
                .map(SpaceMarine::getHealth)
                .collect(Collectors.toList());
        for (Float health: healthOfMarine) {
            sum += health;
        }

        if(sum == 0){
            messenger.printMessage(messenger.getNoElementsInCollection());
        }
        else {
            messenger.printMessage(messenger.getPrintSumOfHealthMessage(sum));
        }
    }

    @Override
    public void removeById(int id) {
        SpaceMarine spaceMarine1 = null;
        try {
            spaceMarine1 = collectionManager.getStream().filter(spaceMarine -> spaceMarine != null)
                    .filter(spaceMarine -> spaceMarine.getId() == id)
                    .findFirst().get();
        }
        catch (NoSuchElementException e){
            messenger.printErrorMessage(messenger.getNoSuchElementInCollection());
        }
        collectionManager.removeElement(spaceMarine1);
    }

    @Override
    public void updateId(int id) {
        changeFields(collectionManager.getStream()
                .filter(spaceMarine -> spaceMarine != null)
                .filter(spaceMarine -> spaceMarine.getId() == id)
                .findFirst()
                .get());
    }

    @Override
    public void insertAt(int index) {
        collectionManager.addElement(inputManager.readSpaceMarine(messenger), index);
    }

    @Override
    public void executeScript(String fileName) {
        if (lastScripts.contains(fileName)){
            messenger.printErrorMessage(messenger.getUncorrectedScript());
            return;
        }

        lastScripts.add(fileName);

        application.runFromFile(fileName);

        lastScripts.remove(fileName);
    }

    private void changeFields(SpaceMarine spaceMarine1){
        SpaceMarine spaceMarine2 = inputManager.readSpaceMarine(messenger);
        spaceMarine1.setName(spaceMarine2.getName());
        spaceMarine1.setCoordinates(spaceMarine2.getCoordinates());
        spaceMarine1.setCreationDate(spaceMarine2.getCreationDate());
        spaceMarine1.setHealth(spaceMarine2.getHealth());
        spaceMarine1.setCategory(spaceMarine2.getCategory());
        spaceMarine1.setWeaponType(spaceMarine2.getWeaponType());
        spaceMarine1.setMeleeWeapon(spaceMarine2.getMeleeWeapon());
        spaceMarine1.setChapter(spaceMarine2.getChapter());
    }

}
