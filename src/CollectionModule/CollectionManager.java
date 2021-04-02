package CollectionModule;

import CollectionModule.BaseClass.SpaceMarine;
import InputOutputModule.FileModule.FileManagerActions;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Класс Менеджера коллекции
 */
public class CollectionManager implements CollectionManagerActions {

    /**
     * Коллекция
     */
    private ArrayList<SpaceMarine> collection;

    /**
     * Дата создания коллекции
     */
    private Date creationDate;

    /**
     * Менеджер для сохранения
     */
    private FileManagerActions fileManager;

    public CollectionManager(FileManagerActions fileManager){
        this.fileManager = fileManager;
        this.collection = new ArrayList<>();
        creationDate = new Date();
    }

    @Override
    public void addElement(SpaceMarine spaceMarine) {
        collection.add(spaceMarine);
    }

    @Override
    public void addElements(ArrayList<SpaceMarine> spaceMarines) {
        collection.addAll(spaceMarines);
    }

    @Override
    public void addElement(SpaceMarine spaceMarine, int index) {
        if (collection.size() < index){
            for(int i = collection.size(); i < index; i++){
                collection.add(null);
            }
        }
        collection.add(index, spaceMarine);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public void removeElement(SpaceMarine spaceMarine) {
        collection.remove(spaceMarine);
    }

    @Override
    public Stream<SpaceMarine> getStream() {
        return collection.stream();
    }

    @Override
    public Class getType() {
        return collection.getClass();
    }

    @Override
    public int getSize() {
        return collection.size();
    }

    @Override
    public Date getDate() {
        return creationDate;
    }

    @Override
    public void reorder() {
        ArrayList<SpaceMarine> newCollection = new ArrayList<>();
        for (int i = collection.size() - 1; i >= 0; i--) {
            newCollection.add(collection.get(i));
        }
        collection = newCollection;
    }

    @Override
    public void save() {
        fileManager.writeElements(collection);
    }
}
