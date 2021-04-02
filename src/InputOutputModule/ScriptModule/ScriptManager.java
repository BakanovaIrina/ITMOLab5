package InputOutputModule.ScriptModule;

import CollectionModule.BaseClass.SpaceMarine;
import CollectionModule.SpaceMarineCreation.SpaceMarineCreatorActions;
import InputOutputModule.InputConverterAction;
import ExceptionModule.UncorrectedFieldException;
import MessengerModule.Messenger;

import java.util.Date;

/**
 * Класс, взаимодействующий с скриптом
 */
public class ScriptManager implements ScriptInputActions {

    /**
     * Считыватель того, что находится в самом файле скрипта
     */
    ScriptReaderActions reader;

    /**
     * Конвертер для получаемого
     */
    InputConverterAction inputConverter;

    /**
     * Создатель элементов SpaceMarine
     */
    SpaceMarineCreatorActions creator;

    /**
     * Конструктор
     * @param reader - считыватель
     * @param inputConverter - конвертер
     * @param creator - создатель
     */
    public ScriptManager(ScriptReaderActions reader, InputConverterAction inputConverter,
                         SpaceMarineCreatorActions creator) {
        this.reader = reader;
        this.inputConverter = inputConverter;
        this.creator = creator;
    }

    @Override
    public SpaceMarine readSpaceMarine(Messenger messenger) {
        try {
            String name = reader.read();
            String stringX = reader.read();
            String stringY = reader.read();
            String stringHealth = reader.read();
            String stringCategory = reader.read();
            String stringWeapon = reader.read();
            String stringMeleeWeapon = reader.read();
            String chapterName = reader.read();
            String parentLegion = reader.read();
            String stringNumberOfMarines = reader.read();

            return creator.createSpaceMarine(name, creator.createCoordinates(inputConverter.convertToFloat(stringX),
                    inputConverter.convertToDouble(stringY)), new Date(), inputConverter.convertToInt(stringHealth),
                    inputConverter.convertToAstartesCategory(stringCategory), inputConverter.convertToWeapon(stringWeapon),
                    inputConverter.convertToMeleeWeapon(stringMeleeWeapon),
                    creator.createChapter(chapterName, parentLegion, inputConverter.convertToInt(stringNumberOfMarines)));
        } catch (UncorrectedFieldException | NumberFormatException e) {
            messenger.printErrorMessage(messenger.getUncorrectedField());
        }
        return null;
    }

    @Override
    public String[] readCommand() {
        return inputConverter.convertToCommand(reader.read());
    }

    @Override
    public boolean isReady() {
        return reader.isReady();
    }
}
