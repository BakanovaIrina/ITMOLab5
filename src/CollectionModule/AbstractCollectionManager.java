package CollectionModule;

import CollectionModule.BaseClass.SpaceMarine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Абстрактный класс, осуществляющий работу с коллекцией
 */
public abstract class AbstractCollectionManager implements CollectionManagerDoings{

    /**
     * Поле с представлением формата даты
     */
    public DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Поле самой коллекции
     */
    private ArrayList<SpaceMarine> collection;

    /**
     * Конструктор
     * @param collection - коллекция
     */
    AbstractCollectionManager(ArrayList<SpaceMarine> collection){
        this.collection = collection;
    }

    protected ArrayList<SpaceMarine> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<SpaceMarine> collection) {
        this.collection = collection;
    }
}
