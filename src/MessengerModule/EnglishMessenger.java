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
public class EnglishMessenger extends Messenger {

    /**
     * Поле для конвертации даты при выводе (для красоты)
     */
    private final DateConverterActions dateConverter;

    /**
     * Конструктор
     * @param dateConverter - то, что будет конвертировать дату
     */
    public EnglishMessenger(DateConverterActions dateConverter) {
        this.dateConverter = dateConverter;
    }
    @Override
    public String getNoSuchCommandMessage() {
        return "This command is unknown";
    }

    @Override
    public String getUncorrectedSize() {
        return "The size entered does not meet the requirements";
    }

    @Override
    public String getUncorrectedField() {
        return "One or more fields were entered incorrectly. Element not created";
    }

    @Override
    public String getUncorrectedFile() {
        return "The file is not correct";
    }

    @Override
    public String getNoInputArgs(String fileName) {
        return "There are not any input args. File name will be change on \""
                + fileName + "\"";
    }

    @Override
    public String getNoInputCommandValue() {
        return "You don't input value to this command";
    }

    @Override
    public String getUncorrectedScript() {
        return "An attempt was found to loop the program, execute_script command will not be executed";
    }

    @Override
    public String getHelloMessage() {
        return "You choose English language";
    }

    @Override
    public String getInputNameMessage() {
        return "Enter the name of the soldier:";
    }

    @Override
    public String getInputCoordinateXMessage() {
        return "Enter a value for the X coordinate:";
    }

    @Override
    public String getInputCoordinateYMessage() {
        return "Enter a value for the Y coordinate:";
    }

    @Override
    public String getInputHealthMessage() {
        return "Enter the value of the marine's health:";
    }

    @Override
    public String getInputCategoryMessage() {
        return "Enter the value of the Astartes Category:";
    }

    @Override
    public String getInputWeaponMessage() {
        return "Enter the value of the Weapon:";
    }

    @Override
    public String getInputMeleeWeaponMessage() {
        return "Enter the value of the MeleeWeapon:";
    }

    @Override
    public String getInputChapterNameMessage() {
        return "Enter the Chapter Name:";
    }

    @Override
    public String getInputParentLegionMessage() {
        return "Enter the Parent Legion:";
    }

    @Override
    public String getInputNumberOfMarinesMessage() {
        return "Enter the number of marines:";
    }

    @Override
    public String getEnumCategoryMessage() {
        Field[] astartes = AstartesCategory.class.getDeclaredFields();
        String s = "Available fields for Astartes Category:";
        for (int i = 0; i < astartes.length - 1; i++) {
            s = s + "\n" + astartes[i].getName();
        }
        return s;
    }

    @Override
    public String getEnumWeaponMessage() {
        Field[] weapons = Weapon.class.getDeclaredFields();
        String s = "Available fields for Weapon:";
        for (int i = 0; i < weapons.length - 1; i++) {
            s = s + "\n" + weapons[i].getName();
        }
        return s;
    }

    @Override
    public String getEnumMeleeWeaponMessage() {
        Field[] meleeWeapons = MeleeWeapon.class.getDeclaredFields();
        String s = "Available fields for MeleeWeapon:";
        for (int i = 0; i < meleeWeapons.length - 1; i++) {
            s = s + "\n" + meleeWeapons[i].getName();
        }
        return s;
    }

    @Override
    public String getInfoAddMessage() {
        return "add {element}: add a new element to the collection";
    }

    @Override
    public String getInfoAddIfMinMessage() {
        return "add_if_min {element}: add a new element to the collection if its value is less than" +
                " the smallest element in this collection";
    }

    @Override
    public String getInfoAverageOfHealthMessage() {
        return "average_of_health: display the average of the health field" +
                "for all elements of the collection";
    }

    @Override
    public String getInfoClearMessage() {
        return "clear: clear the collection";
    }

    @Override
    public String getInfoExecuteScriptMessage() {
        return "execute_script file_name: read and execute the script from the specified file. \n" +
                "The script contains commands in the same form in which the user enters them interactively";
    }

    @Override
    public String getInfoExitMessage() {
        return "exit: exit the program (without saving to file)";
    }

    @Override
    public String getInfoGroupCountingByChapterMessage() {
        return "group_counting_by_chapter: group elements of the collection by field value " +
                "chapter, print the number of elements in each group";
    }

    @Override
    public String getInfoHelpMessage() {
        return "help: display help for available commands";
    }

    @Override
    public String getInfoInsertAtMessage() {
        return "insert_at index {element}: add a new element at the given position";
    }

    @Override
    public String getInfoInfoMessage() {
        return "info: print information about the collection to standard output " +
                "(type, date of initialization, number of elements)";
    }

    @Override
    public String getInfoRemoveByIdMessage() {
        return "remove_by_id id: remove an element from the collection by its id";
    }

    @Override
    public String getInfoReorderMessage() {
        return "reorder: sort the collection in reverse order";
    }

    @Override
    public String getInfoSaveMessage() {
        return "save : save collection to file";
    }

    @Override
    public String getInfoShowMessage() {
        return "show: print all elements of the collection to standard output" +
                "in string representation";
    }

    @Override
    public String getInfoSumOfHealthMessage() {
        return "sum_of_health: Print the sum of the health field values for all items in the collection";
    }

    @Override
    public String getPrintSumOfHealthMessage(Float sum) {
        return "Sum of health: " + sum;
    }

    @Override
    public String getInfoUpdateIdMessage() {
        return "update id {element}: update the id value of the collection element whose id is equal to " +
                "the given one";
    }

    @Override
    public String getPrintAverageOfHealthMessage(Float average) {
        return "Average of health: " + average;
    }

    @Override
    public String getSumMarinesInChapterMessage(String chapter, Long sum) {
        return "On chapter " + chapter + ": " + sum + "SpaceMarine(s)";
    }

    @Override
    public String getPrintInfo(String type, Date date, int size) {
        return "The type of this collection: " + type + "\n" +
                "Initialisation date: " + date + "\n" +
                "Size Of Collection: " + size;
    }

    @Override
    public String getNoElementsInCollection() {
        return "This collection is empty";
    }

    @Override
    public String getElementMessage(SpaceMarine spaceMarine) {
        return "Collection element id: " + spaceMarine.getId() + "\n" +
                "Collection element name: " + spaceMarine.getName() + "\n" +
                "Creation date: " + dateConverter.convertDateToStringFormat(spaceMarine.getCreationDate()) + "\n" +
                "Coordinates: " + "\n" +
                "Coordinate X: " + spaceMarine.getCoordinates().getX() + "\n" +
                "Coordinate Y: " + spaceMarine.getCoordinates().getY() + "\n" +
                "Health: " + spaceMarine.getHealth() + "\n" +
                "Astartes Category: " + spaceMarine.getCategory() + "\n" +
                "Weapon: " + spaceMarine.getWeaponType() + "\n" +
                "Melee Weapon: " + spaceMarine.getMeleeWeapon() + "\n" +
                "Chapter: " + spaceMarine.getChapter().getName() + "\n" +
                "Parent Legion: " + spaceMarine.getChapter().getParentLegion() + "\n" +
                "Space Marines count: " + spaceMarine.getChapter().getMarinesCount() + "\n";
    }

    @Override
    public String getNoSuchElementInCollection() {
        return "There is not such element in collection";
    }

    @Override
    public String getIsNotMinMessage() {
        return "This element is not min";
    }
}
