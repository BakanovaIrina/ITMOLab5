package MessengerModule;

import ApplicationModule.DateConverterActions;
import CollectionModule.BaseClass.AstartesCategory;
import CollectionModule.BaseClass.MeleeWeapon;
import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.BaseClass.Weapon;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Класс для получения сообщений на английском языке
 */
public class RussianMessenger extends Messenger{

    /**
     * Поле для конвертации даты при выводе (для красоты)
     */
    private final DateConverterActions dateConverter;

    /**
     * Конструктор
     * @param dateConverter - то, что будет конвертировать дату
     */
    public RussianMessenger(DateConverterActions dateConverter) {
        this.dateConverter = dateConverter;
    }

    @Override
    public String getNoSuchCommandMessage() {
        return "Мы не знаем данную команду";
    }

    @Override
    public String getUncorrectedSize() {
        return "Размер введенного не соответствует требованиям";
    }

    @Override
    public String getUncorrectedField() {
        return "Одно или несколько полей было введено некорректно. Элемент не создан";
    }

    @Override
    public String getUncorrectedFile() {
        return "Извините, но данный файл не доступен";
    }

    @Override
    public String getNoInputArgs(String fileName) {
        return "Не были введены аргументы командной строки. Имя файла будет заменено на \""
                + fileName + "\"";
    }

    @Override
    public String getNoInputCommandValue() {
        return "Не было введено значение, нужное для исполнения команды";
    }

    @Override
    public String getUncorrectedScript() {
        return "Была найдена попытка зациклить программу. Команда execute_script не будет выполнена";
    }

    @Override
    public String getHelloMessage() {
        return "Вы выбрали русский язык";
    }

    @Override
    public String getInfoAddMessage() {
        return "add {element}: добавить новый элемент в коллекцию";
    }

    @Override
    public String getInfoAddIfMinMessage() {
        return "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, " +
                "чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String getInfoAverageOfHealthMessage() {
        return "average_of_health : вывести среднее значение поля health " +
                "для всех элементов коллекции";
    }

    @Override
    public String getInfoClearMessage() {
        return "clear : очистить коллекцию";
    }

    @Override
    public String getInfoExecuteScriptMessage() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. \n" +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь " +
                "в интерактивном режиме";
    }

    @Override
    public String getInfoExitMessage() {
        return "exit : завершить программу (без сохранения в файл)";
    }

    @Override
    public String getInfoGroupCountingByChapterMessage() {
        return "group_counting_by_chapter : сгруппировать элементы коллекции по значению поля " +
                "chapter, вывести количество элементов в каждой группе";
    }

    @Override
    public String getSumMarinesInChapterMessage(String chapter, Long sum) {
        return "На главе " + chapter + " находятся: " + sum + " бойцов";
    }

    @Override
    public String getInfoHelpMessage() {
        return "help : вывести справку по доступным командам";
    }

    @Override
    public String getInfoInsertAtMessage() {
        return "insert_at index {element} : добавить новый элемент в заданную позицию";
    }

    @Override
    public String getInfoInfoMessage() {
        return "info : вывести в стандартный поток вывода информацию о коллекции " +
                "(тип, дата инициализации, количество элементов)";
    }

    @Override
    public String getPrintInfo(String type, Date date, int size) {
        return  "Тип данной коллекции: " + type + "\n" +
                "Дата инициализации коллекции: " + dateConverter.convertDateToStringFormat(date) + "\n" +
                "Размер данной коллекции: " + size;
    }

    @Override
    public String getInfoRemoveByIdMessage() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }

    @Override
    public String getInfoReorderMessage() {
        return "reorder : отсортировать коллекцию в порядке, обратном нынешнему";
    }

    @Override
    public String getInfoSaveMessage() {
        return "save : сохранить коллекцию в файл";
    }

    @Override
    public String getInfoShowMessage() {
        return "show : вывести в стандартный поток вывода все элементы коллекции " +
                "в строковом представлении";
    }

    @Override
    public String getInfoSumOfHealthMessage() {
        return "sum_of_health : вывести сумму значений поля health для всех элементов коллекции";
    }

    @Override
    public String getPrintSumOfHealthMessage(Float sum) {
        return "Сумма здоровья элементов коллекции: " + sum;
    }

    @Override
    public String getInfoUpdateIdMessage() {
        return "update id {element} : обновить значение id элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getPrintAverageOfHealthMessage(Float average) {
        return "Среднее значение здоровья: " + average;
    }

    @Override
    public String getNoElementsInCollection() {
        return "Данная коллекция пуста";
    }

    @Override
    public String getElementMessage(SpaceMarine spaceMarine) {
        return  "Id элемента коллекции: " + spaceMarine.getId() + "\n" +
                "Имя элемента коллекции: " + spaceMarine.getName() + "\n" +
                "Дата создания элемента: "
                + dateConverter.convertDateToStringFormat(spaceMarine.getCreationDate()) + "\n" +
                "Координаты элемента: " + "\n" +
                "Координата X: " + spaceMarine.getCoordinates().getX() + "\n" +
                "Координата Y: " + spaceMarine.getCoordinates().getY() + "\n" +
                "Здоровье: " + spaceMarine.getHealth() + "\n" +
                "Категория Астартес: " + spaceMarine.getCategory() + "\n" +
                "Оружие: " + spaceMarine.getWeaponType() + "\n" +
                "Оружие ближнего боя: " + spaceMarine.getMeleeWeapon() + "\n" +
                "Глава: " + spaceMarine.getChapter().getName() + "\n" +
                "Родительский регион: " + spaceMarine.getChapter().getParentLegion() + "\n" +
                "Морских пехотинцев: " + spaceMarine.getChapter().getMarinesCount() + "\n";
    }

    @Override
    public String getNoSuchElementInCollection() {
        return "Нет подходящего элемента в коллеции";
    }

    @Override
    public String getIsNotMinMessage() {
        return "Элемент не является минимальным";
    }

    @Override
    public String getInputNameMessage() {
        return "Введите имя бойца:";
    }

    @Override
    public String getInputCoordinateXMessage() {
        return "Введите значение координаты X:";
    }

    @Override
    public String getInputCoordinateYMessage() {
        return "Введите значение координаты Y:";
    }

    @Override
    public String getInputHealthMessage() {
        return "Введите значение здоровья бойца:";
    }

    @Override
    public String getInputCategoryMessage() {
        return "Введите категорию бойца:";
    }

    @Override
    public String getInputWeaponMessage() {
        return "Введите основное оружие бойца:";
    }

    @Override
    public String getInputMeleeWeaponMessage() {
        return "Введите оружие ближнего боя бойца:";
    }

    @Override
    public String getInputChapterNameMessage() {
        return "Введите название главы:";
    }

    @Override
    public String getInputParentLegionMessage() {
        return "Введите родительский регион:";
    }

    @Override
    public String getInputNumberOfMarinesMessage() {
        return "Введите количество бойцов:";
    }

    @Override
    public String getEnumCategoryMessage() {
        Field[] astartes = AstartesCategory.class.getDeclaredFields();
        String s = "Доступные поля для категории:";
        for (int i = 0; i < astartes.length - 1; i++) {
            s = s + "\n" + astartes[i].getName();
        }
        return s;
    }

    @Override
    public String getEnumWeaponMessage() {
        Field[] weapons = Weapon.class.getDeclaredFields();
        String s = "Доступные поля для оружия:";
        for (int i = 0; i < weapons.length - 1; i++) {
            s = s + "\n" + weapons[i].getName();
        }
        return s;
    }

    @Override
    public String getEnumMeleeWeaponMessage() {
        Field[] meleeWeapons = MeleeWeapon.class.getDeclaredFields();
        String s = "Доступные поля для оружия ближнего боя:";
        for (int i = 0; i < meleeWeapons.length - 1; i++) {
            s = s + "\n" + meleeWeapons[i].getName();
        }
        return s;
    }
}
