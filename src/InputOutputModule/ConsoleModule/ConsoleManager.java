package InputOutputModule.ConsoleModule;

import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.SpaceMarineCreation.SpaceMarineCreatorActions;
import ExceptionModule.UncorrectedFieldException;
import InputOutputModule.InputConverterAction;
import InputOutputModule.Reader;
import MessengerModule.Messenger;

import java.util.Date;

/**
 * Класс для взаимодействия с консолью
 */
public class ConsoleManager implements ConsoleManagerActions {
    /**
     * Класс, создающий элемент SpaceMarine
     */
    SpaceMarineCreatorActions creator;

    /**
     * Считыватель ввода
     */
    Reader reader;

    /**
     * Конвертер для ввода
     */
    InputConverterAction inputConverter;

    /**
     * Конструктор
     * @param creator - создатель SpaceMarine
     * @param inputConverter - конвертер
     * @param reader - считыватель
     */
    public ConsoleManager(SpaceMarineCreatorActions creator, InputConverterAction inputConverter,
                          Reader reader) {
        this.creator = creator;
        this.reader = reader;
        this.inputConverter = inputConverter;
    }

    @Override
    public String[] readCommand() {
        return inputConverter.convertToCommand(reader.read());
    }

    public String readLanguage(){
        return inputConverter.convertToString(reader.read());
    }

    @Override
    public SpaceMarine readSpaceMarine(Messenger messenger) {
        try {
            messenger.printMessage(messenger.getInputNameMessage());
            String name = reader.read();

            messenger.printMessage(messenger.getInputCoordinateXMessage());
            String stringX = reader.read();
            messenger.printMessage(messenger.getInputCoordinateYMessage());
            String stringY = reader.read();

            messenger.printMessage(messenger.getInputHealthMessage());
            String stringHealth = reader.read();

            messenger.printMessage(messenger.getInputCategoryMessage());
            messenger.printMessage(messenger.getEnumCategoryMessage());
            String stringCategory = reader.read();

            messenger.printMessage(messenger.getInputWeaponMessage());
            messenger.printMessage(messenger.getEnumWeaponMessage());
            String stringWeapon = reader.read();

            messenger.printMessage(messenger.getInputMeleeWeaponMessage());
            messenger.printMessage(messenger.getEnumMeleeWeaponMessage());
            String stringMeleeWeapon = reader.read();

            messenger.printMessage(messenger.getInputChapterNameMessage());
            String chapterName = reader.read();

            messenger.printMessage(messenger.getInputParentLegionMessage());
            String parentLegion = reader.read();

            messenger.printMessage(messenger.getInputNumberOfMarinesMessage());
            String stringNumberOfMarines = reader.read();

            return creator.createSpaceMarine(name, creator.createCoordinates(inputConverter.convertToFloat(stringX),
                    inputConverter.convertToDouble(stringY)), new Date(), inputConverter.convertToInt(stringHealth),
                    inputConverter.convertToAstartesCategory(stringCategory), inputConverter.convertToWeapon(stringWeapon),
                    inputConverter.convertToMeleeWeapon(stringMeleeWeapon),
                    creator.createChapter(chapterName, parentLegion, inputConverter.convertToInt(stringNumberOfMarines)));
        } catch (UncorrectedFieldException | IllegalArgumentException e) {
            messenger.printErrorMessage(messenger.getUncorrectedField());
        }
        return null;
    }

}
