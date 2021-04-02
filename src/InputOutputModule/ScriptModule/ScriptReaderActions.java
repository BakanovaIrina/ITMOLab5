package InputOutputModule.ScriptModule;

import InputOutputModule.Reader;

/**
 * Интерфейс, описывающий действия для читателя из скрипта
 */
public interface ScriptReaderActions extends Reader {
    /**
     * Метод, показывающий, считаны ли все данные
     * @return true - что-то осталось, false - все считано
     */
    boolean isReady();
}
