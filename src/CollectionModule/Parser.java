package CollectionModule;

import CollectionModule.BaseClass.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Интерфейс, осуществляющий взаимодействие с файлом в формате CSV
 */
public interface Parser {
    /**
     * Метод, сохраняющий коллекцию в формате CSV
     * @param collectionManager - менеджер коллекции
     * @param fileName - имя файла
     * @param dateFormat - формат записи даты
     */
    static void saveInCsv(CollectionManager collectionManager, String fileName, DateFormat dateFormat){
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName), "Cp866"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Инвините, произошла проблема с кодировкой");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден");
        }
        ArrayList<SpaceMarine> collection = collectionManager.getCollection();
        for (SpaceMarine marine : collection) {
            String date = dateFormat.format(marine.getCreationDate());
            printWriter.println(marine.getName() + ";" +
                    "\"" + marine.getCoordinates().getX() + " " + marine.getCoordinates().getY() + "\"" + ";"
                    + date + ";" + marine.getHealth() + ";" + marine.getCategory() + ";"
                    + marine.getWeaponType() + ";" + marine.getMeleeWeapon() + ";" + "\"" + marine.getChapter().getName()
                    + "," + marine.getChapter().getParentLegion() + "," + marine.getChapter().getMarinesCount() + "\";");
        }
        printWriter.close();
    }

    /**
     * Метод, обрабатывающий строку в формате CSV, в которой находятся поля объекта SpaceMarine
     * @param input - обрабатываемая строка
     * @return - элемент SpaceMarine
     */
    static SpaceMarine toSpaceMarine(String input, DateFormat dateFormat){
        boolean isNormal = true;
        SpaceMarine spaceMarine = null;
        final int countField = SpaceMarine.class.getDeclaredFields().length - 1;

        String[] value = input.split(";");

        if (value.length != countField){
            return null;
        }
        int id = Generator.generateId();
        try {
            String name = value[0];
            Coordinates coordinates;
            value[1] = value[1].replace("\"", "");
            String[] stringCoordinates = value[1].split(" ");
            coordinates = new Coordinates(Float.parseFloat(stringCoordinates[0]), Float.parseFloat(stringCoordinates[1]));
            if(stringCoordinates.length != 2 || !Checker.check(coordinates)){
                System.out.println("Неверно указаны координаты элемента");
                isNormal = false;
            }
            Date date = null;
            try {
                date = dateFormat.parse(value[2]);
            } catch (ParseException e) {
                isNormal = false;
            }
            float health = Float.parseFloat(value[3]);
            AstartesCategory category = AstartesCategory.valueOf(value[4]);
            Weapon weapon = Weapon.valueOf(value[5]);
            MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(value[6]);
            value[7] = value[7].replace("\"", "");
            String[] fullChapter = value[7].split(",");
            if(fullChapter.length != 3){
                isNormal = false;
            }
            Chapter chapter = new Chapter(fullChapter[0], fullChapter[1], Integer.parseInt(fullChapter[2]));

            spaceMarine = new SpaceMarine(id, name, coordinates, date, health, category, weapon, meleeWeapon, chapter);
        }
        catch (IllegalArgumentException e){
            isNormal = false;
            System.out.println("Какое-то значение введено неверно");
        }
        if(isNormal){
            if(!Checker.check(spaceMarine)){
                isNormal = false;
            }
        }
        if (isNormal){
            System.out.println("Элемент " + spaceMarine.getName() + " был добавлен успешно");
            return spaceMarine;
        }
        else {
            System.out.println("Элемент не был добавлен в коллекцию (не соблюдены условия)");
            return null;
        }
    }
}
