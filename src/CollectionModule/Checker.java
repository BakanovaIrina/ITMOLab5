package CollectionModule;

import CollectionModule.BaseClass.AstartesCategory;
import CollectionModule.BaseClass.Chapter;
import CollectionModule.BaseClass.Coordinates;
import CollectionModule.BaseClass.SpaceMarine;

import java.util.ArrayList;

/**
 * Класс для проверки значений полей и объектов
 */
public interface Checker {
    /**
     * Проверяет значение имени
     * @param name
     * @return
     */
    static boolean check(String name){
        return (!name.equals("") && checkNull(name));
    }

    /**
     * Проверяет значение координат
     * @param coordinates
     * @return
     */
    static boolean check(Coordinates coordinates){
        if (!(checkNull(coordinates) && checkNull(coordinates.getX()) && checkNull(coordinates.getY()))){
            return false;
        }
        return coordinates.getX() >= -341 && coordinates.getY() >= -539;
    }

    /**
     * Проверяет значение здоровья
     * @param health
     * @return
     */
    static boolean check(float health){
        return health > 0;
    }

    /**
     * Проверяет значение категории
     * @param category
     * @return
     */
    static boolean check(AstartesCategory category){
        return !(category == null);
    }

    /**
     * Проверяет значение главы
     * @param chapter
     * @return
     */
    static boolean check(Chapter chapter){
        return check(chapter.getName()) && (checkNull(chapter.getMarinesCount())) &&
                (chapter.getMarinesCount() > 0) && (chapter.getMarinesCount() < 1000);
    }

    /**
     * Проверяет, является ли введенное значение null
     * @param o
     * @return
     */
    static boolean checkNull(Object o){
        return !(o == null);
    }

    /**
     * Проверяет правильность ввода объекта SpaceMarine
     * @param spaceMarine
     * @return
     */
    static boolean check(SpaceMarine spaceMarine){
        return check(spaceMarine.getName()) && check(spaceMarine.getCoordinates()
        ) && check(spaceMarine.getHealth()) && check(spaceMarine.getCategory())
                && checkNull(spaceMarine.getWeaponType()) && check(spaceMarine.getChapter());
    }

    /**
     * Проверяет ввод значения id
     * @param id
     * @param collection
     * @return
     */
    static boolean checkId(int id, ArrayList<SpaceMarine> collection){
        for (SpaceMarine spaceMarine: collection) {
            if(spaceMarine == null){
                return true;
            }
            if(spaceMarine.getId() == id){
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет значение индекса
     * @param index
     * @return
     */
    static boolean checkIndex(int index){
        return index < 0;
    }

}
