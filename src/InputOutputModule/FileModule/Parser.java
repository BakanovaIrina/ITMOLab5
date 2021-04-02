package InputOutputModule.FileModule;

import CollectionModule.BaseClass.*;
import CollectionModule.SpaceMarineCreation.SpaceMarineCreatorActions;
import ExceptionModule.UncorrectedFieldException;
import ExceptionModule.UncorrectedSizeException;
import ApplicationModule.DateConverterActions;

import java.text.ParseException;

/**
 * Примитивный парсер
 */
public class Parser implements ParserActions{

    /**
     * Создатель SpaceMarine
     */
    SpaceMarineCreatorActions creator;

    /**
     * Конвертер для даты
     */
    DateConverterActions dateConverter;

    /**
     * Количество полей в классе
     */
    final int countField;

    /**
     * Конструктор
     * @param spaceMarineCreator - креатор
     * @param dateConverter - конвертер
     */
    public Parser(SpaceMarineCreatorActions spaceMarineCreator, DateConverterActions dateConverter){
        this.creator = spaceMarineCreator;
        this.dateConverter = dateConverter;
        countField = SpaceMarine.class.getDeclaredFields().length - 1;
    }

    @Override
    public SpaceMarine parseToSpaceMarine(String input) throws UncorrectedSizeException,
            ParseException, UncorrectedFieldException {

        String[] value = input.split(";");

        if (value.length != countField){
            throw new UncorrectedSizeException();
        }

        String[] stringCoordinates = value[1].replace("\"", "").split(" ");

        if(stringCoordinates.length != 2){
            throw new UncorrectedSizeException();
        }

        String[] fullChapter = value[7].replace("\"", "").split(",");

        if(fullChapter.length != 3){
            throw new UncorrectedSizeException();
        }

        return creator.createSpaceMarine(value[0], creator.createCoordinates(Float.parseFloat(stringCoordinates[0]),
                Double.parseDouble(stringCoordinates[1])), dateConverter.convertStringToDate(value[2]), Float.parseFloat(value[3]),
                AstartesCategory.valueOf(value[4]), Weapon.valueOf(value[5]), MeleeWeapon.valueOf(value[6]),
                creator.createChapter(fullChapter[0], fullChapter[1], Integer.parseInt(fullChapter[2])));
    }

    @Override
    public String parseToCsv(SpaceMarine spaceMarine) {
        String date = dateConverter.convertDateToStringFormat(spaceMarine.getCreationDate());
        return (spaceMarine.getName() + ";" +
                "\"" + spaceMarine.getCoordinates().getX() + " " + spaceMarine.getCoordinates().getY() + "\"" + ";"
                + date + ";" + spaceMarine.getHealth() + ";" + spaceMarine.getCategory() + ";"
                + spaceMarine.getWeaponType() + ";" + spaceMarine.getMeleeWeapon() + ";" + "\""
                + spaceMarine.getChapter().getName() + "," + spaceMarine.getChapter().getParentLegion() + ","
                + spaceMarine.getChapter().getMarinesCount() + "\";");
    }
}
