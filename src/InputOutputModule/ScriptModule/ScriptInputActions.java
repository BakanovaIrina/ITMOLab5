package InputOutputModule.ScriptModule;

import InputOutputModule.InputManagerActions;

/**
 * Интерфейс, описывающий действия для ScriptManager, расширяющие действия обычного InputManager
 */
public interface ScriptInputActions extends InputManagerActions {

    /**
     * Метод, показывающий готовность
     * @return true - готов, false - нет
     */
    boolean isReady();
}
