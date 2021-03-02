package CollectionModule;

import CollectionModule.BaseClass.*;
import ConsoleModule.AbstractConsoleManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * Класс, взаимодействующий с коллекцией (непосредственно выполняет соответствующие команды)
 */
public class CollectionManager extends AbstractCollectionManager{

    /**
     * Дата создания коллекции
     */
    private Date creationData;

    /**
     * Имя файла, из которого осуществляется работа с коллекцией (ввод коллекции и сохранение)
     */
    public static String collectionFileName;

    /**
     * Конструктор
     * @param collectionFileName - имя файла для работы с колекцией
     */
    public CollectionManager(String collectionFileName){
        super(new ArrayList<>());
        creationData = new Date();
        if (Checker.check(collectionFileName)){
            CollectionManager.collectionFileName = collectionFileName;
        }
    }

    @Override
    public void info() {
        System.out.println("Тип коллекции: " + getCollection().getClass().getName());
        String date = dateFormat.format(creationData);
        System.out.println("Дата инициализации: " + date);
        System.out.println("Количество элементов в коллекции: " + getCollection().size());
    }

    @Override
    public void show() {
        boolean hasNull = true;
        if (getCollection().size() == 0){
            System.out.println("Данная коллекция не имеет элементов");
        }
        else {
            for (int i = 0; i < getCollection().size(); i++){
                if(getCollection().get(i) != null){
                    hasNull = false;
                    System.out.println("Id элемента коллекции: " + getCollection().get(i).getId());
                    System.out.println("Имя элемента коллекции: " + getCollection().get(i).getName());
                    String date = dateFormat.format(getCollection().get(i).getCreationDate());
                    System.out.println("Дата создания элемента: " + date);
                    System.out.println("Координаты элемента: ");
                    System.out.println("Координата X: " + getCollection().get(i).getCoordinates().getX());
                    System.out.println("Координата Y: " + getCollection().get(i).getCoordinates().getY());
                    System.out.println("Здоровье: " + getCollection().get(i).getHealth());
                    System.out.println("Категория Астартес: " + getCollection().get(i).getCategory());
                    System.out.println("Оружие: " + getCollection().get(i).getWeaponType());
                    System.out.println("Оружие ближнего боя: " + getCollection().get(i).getMeleeWeapon());
                    System.out.println("Глава: " + getCollection().get(i).getChapter().getName() + "\n" +
                                "Родительский регион: " + getCollection().get(i).getChapter().getParentLegion() + "\n" +
                                "Морских пехотинцев: " + getCollection().get(i).getChapter().getMarinesCount() + "\n");
                }
            }
        }
        if(hasNull && getCollection().size() != 0){
            System.out.println("В данной коллекции нет элементов");
        }
    }

    @Override
    public void clear(){
        getCollection().clear();
    }

    @Override
    public void sumOfHealth() {
        int sum = 0;
        for (SpaceMarine marine: getCollection()) {
            sum += marine.getHealth();
        }
        System.out.println("Суммарное здоровье: " + sum);
    }

    @Override
    public void averageOfHealth() {
        float average = 0f;
        for (SpaceMarine marine: getCollection()) {
            average += marine.getHealth();
        }
        average = average / getCollection().size();
        if (getCollection().size() == 0){
            System.out.println("В данной коллекции нет элементов. Мы не можем посчитать того, чего нет!");
        }
        else {
            System.out.println("Среднее значение здоровья: " + average);
        }
    }

    @Override
    public void removeById(AbstractConsoleManager consoleManager, int id) {
        for (SpaceMarine marine: getCollection()
             ) {
            if (marine.getId() == id){
                getCollection().remove(marine);
                System.out.println("Элемент успешно удален");
                return;
            }
        }
        System.out.println("Такого элемента нет в коллекции. Вы можете попробовать еще раз, введя данную команду");
    }

    @Override
    public void add(AbstractConsoleManager consoleManager) {
        SpaceMarine marine = acceptElement(consoleManager);
        if (Checker.checkNull(marine)){
            addToCollection(marine);
            System.out.println("Данный элемент был успешно создан и добавлен в коллекцию");
        }
        else {
            System.out.println("Вы ввели некорректные значения. Попробуйте еще раз");
        }
    }

    private SpaceMarine acceptElement(AbstractConsoleManager consoleManager){
        System.out.println("Id нового элемента будет сгенерировано автоматически.");
        int id = generateNewId();
        String name = nameInput(consoleManager);
        Coordinates coordinates = coordinatesInput(consoleManager);
        float health = healthInput(consoleManager);
        Date creationDate = new Date();
        AstartesCategory category = categoryInput(consoleManager);
        Weapon weapon = weaponInput(consoleManager);
        MeleeWeapon meleeWeapon = meleeWeaponInput(consoleManager);
        Chapter chapter = chapterInput(consoleManager);

        SpaceMarine marine = new SpaceMarine(id, name, coordinates, creationDate, health,
                category, weapon, meleeWeapon, chapter);
        if(Checker.check(marine)){
            return marine;
        } else {
            System.out.println("Одно из полей было введено неверно. Элемент не создан");
            return null;
        }
    }

    @Override
    public void updateId(AbstractConsoleManager consoleManager){
        int id = idInput(consoleManager);
        if(!Checker.checkId(id, getCollection())){
            for (SpaceMarine marine: getCollection()
                 ) {
                if (marine.getId() == id){
                    marine.setId(generateNewId());
                    break;
                }
            }
            System.out.println("Id успешно обновлен");
        }
        else {
            System.out.println("Извините, но в коллекции нет элемента с таким id");
        }
    }

    @Override
    public void insertAt(AbstractConsoleManager consoleManager, int index) {
        if (Checker.checkIndex(index)){
            System.out.println("Вы ввели отрицательный индекс!");
        }
        else {
            SpaceMarine spaceMarine = acceptElement(consoleManager);
            try{
                getCollection().add(index, spaceMarine);
                if(spaceMarine == null){
                    System.out.println("Одно из полей было введено неправильно. Попробуйте еще раз");
                    return;
                }
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Размер данной коллекции меньше, чем индекс, который вы ввели!");
                System.out.println("Коллекция будет автоматически расширена");
                for (int i = getCollection().size(); i < index; i++){
                    getCollection().add(null);
                }
                getCollection().add(index, spaceMarine);
            }
        }

    }

    @Override
    public void addIfMin(AbstractConsoleManager consoleManager) {
        boolean isMin = true;
        SpaceMarine spaceMarine = acceptElement(consoleManager);
        for (SpaceMarine marine: getCollection()
             ) {
            if (marine.compareTo(spaceMarine) > 0) {
                isMin = false;
            }
        }
        if (isMin && Checker.checkNull(spaceMarine)){
            System.out.println("Вы ввели неподходящие значения.");
        }
        else if (!isMin){
            System.out.println("Элемент не является минимальным");
        }
        else {
            addToCollection(spaceMarine);
            System.out.println("Элемент успешно добавлен в коллекцию");
        }
    }

    @Override
    public void reorder() {
        ArrayList<SpaceMarine> collection = getCollection();
        ArrayList<SpaceMarine> newCollection = new ArrayList<>();
        for(int i = collection.size() - 1; i >= 0; i--){
            newCollection.add(collection.get(i));
        }
        setCollection(newCollection);
    }

    @Override
    public void groupCountingByChapter() {
        ArrayList<SpaceMarine> collection = getCollection();
        HashSet<Chapter> chapters = new HashSet<>();
        for (SpaceMarine marine: collection
             ) {
            if (marine != null){
                chapters.add(marine.getChapter());
            }
        }
        for (Chapter chapter: chapters
             ) {
            int k = 0;
            for (SpaceMarine marine: collection
                 ) {
                if(Checker.checkNull(marine)){
                    if(marine.getChapter().equals(chapter)){
                        k++;
                    }
                }
            }
            System.out.println("На главе "+ chapter.getName() + " находятся: " + k + " бойцов");
        }
        if (collection.size() == 0){
            System.out.println("В данной коллекции нет элементов");
        }
    }

    @Override
    public void save() {
        Parser.saveInCsv(this, collectionFileName, dateFormat);
    }

    /**
     * Метод, генерирующий id, если было найдено совпадаение
     * @return
     */
    private int generateNewId(){
        int id = Generator.generateId();
        while (!Checker.checkId(id, getCollection())){
            id = Generator.generateId();
        }
        return id;
    }

    @Override
    public void addToCollection(SpaceMarine spaceMarine){
        getCollection().add(spaceMarine);
    }

    /**
     * Метод, принимающий введеное пользователем значение id
     * @param consoleManager
     * @return
     */
    private int idInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите значение id, которое хотите обновить:");
        return consoleManager.acceptInt();
    }

    /**
     * Метод, принимающий введеное пользователем значение имени
     * @param consoleManager
     * @return
     */
    private String nameInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите имя бойца:");
        return consoleManager.acceptString();
    }

    /**
     * Метод, принимающий введеное пользователем значение координат
     * @param consoleManager
     * @return
     */
    private Coordinates coordinatesInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите оба значения координат через enter:");
        return new Coordinates(consoleManager.acceptFloat(), consoleManager.acceptDouble());
    }

    /**
     * Метод, принимающий введеное пользователем значение здоровья
     * @param consoleManager
     * @return
     */
    private float healthInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите значение здоровья бойца:");
        return consoleManager.acceptFloat();
    }

    /**
     * Метод, принимающий введеное пользователем значение категории
     * @param consoleManager
     * @return
     */
    private AstartesCategory categoryInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите категорию бойца:");
        return consoleManager.acceptCategory();
    }

    /**
     * Метод, принимающий введеное пользователем значение оружия
     * @param consoleManager
     * @return
     */
    private Weapon weaponInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите основное оружие бойца:");
        return consoleManager.acceptWeapon();
    }

    /**
     * Метод, принимающий введеное пользователем значение оружия ближнего боя
     * @param consoleManager
     * @return
     */
    private MeleeWeapon meleeWeaponInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите оружие ближнего боя бойца:");
        return consoleManager.acceptMeleeWeapon();
    }

    /**
     * Метод, принимающий введеное пользователем значение главы
     * @param consoleManager
     * @return
     */
    private Chapter chapterInput(AbstractConsoleManager consoleManager){
        System.out.println("Введите через enter главу, родительский регион (если он имеется, иначе нажмите enter), \n" +
                "А так же число бойцов:");
        return new Chapter(consoleManager.acceptString(), consoleManager.acceptString(),
                consoleManager.acceptInt());
    }
}
