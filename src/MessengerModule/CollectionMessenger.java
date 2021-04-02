package MessengerModule;

import CollectionModule.BaseClass.SpaceMarine;

/**
 * Интерфейс для сообщений, связанных с действиями с коллекцией
 */
public interface CollectionMessenger {
    /**
     * Метод для получения сообщения о пустой коллекции
     * @return String message
     */
    String getNoElementsInCollection();

    /**
     * Метод для получения сообщения о элементе
     * @param spaceMarine - элемент, для которого выводится сообщение
     * @return String message
     */
    String getElementMessage(SpaceMarine spaceMarine);

    /**
     * Метод для получения сообщения об отсутствии определенного элемента
     * @return String message
     */
    String getNoSuchElementInCollection();

    /**
     * Метод для получения сообщения о неминимальности элемента
     * @return
     */
    String getIsNotMinMessage();
}
