package CollectionModule;

import CollectionModule.BaseClass.SpaceMarine;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Интерфейс, описывающий действия по работе с коллекцией
 */
public interface CollectionManagerActions {

    /**
     * Добавляет элемент в коллекцию
     * @param spaceMarine - добавляемый элемент
     */
    void addElement(SpaceMarine spaceMarine);

    /**
     * Добавляет элементы в коллекцию
     * @param spaceMarines - элементы
     */
    void addElements(ArrayList<SpaceMarine> spaceMarines);

    /**
     * Добавляет элемент в коллекцию по индексу
     * @param spaceMarine - элемент
     * @param index - индекс
     */
    void addElement(SpaceMarine spaceMarine, int index);

    /**
     * Очищает коллекцию
     */
    void clear();

    /**
     * Удаляет элемент из коллекции
     * @param spaceMarine - элемент
     */
    void removeElement(SpaceMarine spaceMarine);

    /**
     * Метод, выдающий поток данных элементов данной коллекции
     * @return поток данных коллекции
     */
    Stream<SpaceMarine> getStream();

    /**
     * Метод, возвращающий тип коллекции
     * @return тип коллекции
     */
    Class getType();

    /**
     * Метод, возвращающий размер
     * @return размер
     */
    int getSize();

    /**
     * Метод, возвращающий дату создания коллекции
     * @return дата
     */
    Date getDate();

    /**
     * Метод, сортирующий коллекцию в обратном порядке
     */
    void reorder();

    /**
     * Метод, сохраняющий коллекцию
     */
    void save();
}
