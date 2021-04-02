package InputOutputModule.ConsoleModule;

import InputOutputModule.InputManagerActions;

/**
 * Интерфейс, расширяющий действия InputManager для ConsoleManager
 */
public interface ConsoleManagerActions extends InputManagerActions {

    /**
     * Метод для ввода языка
     * @return - язык в стоковом представлении
     */
    String readLanguage();
}
