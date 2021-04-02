package InputOutputModule;

import CollectionModule.BaseClass.SpaceMarine;
import MessengerModule.Messenger;

/**
 * Интерфейс, описывающий поведение менеджера, работающего с вводом
 */
public interface InputManagerActions {

    /**
     * Метод, читающий определенный элемент
     * @param messenger - мессенджер для запроса у пользователя соответствующего поля
     * @return - элемент SpaceMarine
     */
    SpaceMarine readSpaceMarine(Messenger messenger);

    /**
     * Метод, читающий команды
     * @return массив из полученного (команда-значение)
     */
    String[] readCommand();
}
