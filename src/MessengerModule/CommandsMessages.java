package MessengerModule;

import java.util.Date;

/**
 * Интерфейс для сообщений, связанных с командами
 */
public interface CommandsMessages {
    /**
     * Метод для получения сообщения о команде add
     * @return String message
     */
    String getInfoAddMessage();

    /**
     * Метод для получения сообщения о команде add_if_min
     * @return String message
     */
    String getInfoAddIfMinMessage();

    /**
     * Метод для получения сообщения о команде average_of_health
     * @return String message
     */
    String getInfoAverageOfHealthMessage();

    /**
     * Метод для получения сообщения команды average_of_health
     * @param average - полученное значение
     * @return String message
     */
    String getPrintAverageOfHealthMessage(Float average);

    /**
     * Метод для получения сообщения о команде clear
     * @return String message
     */
    String getInfoClearMessage();

    /**
     * Метод для получения сообщения о команде execute_script
     * @return String message
     */
    String getInfoExecuteScriptMessage();

    /**
     * Метод для получения сообщения о команде exit
     * @return String message
     */
    String getInfoExitMessage();

    /**
     * Метод для получения сообщения о команде group_counting_by_chapter
     * @return String message
     */
    String getInfoGroupCountingByChapterMessage();

    /**
     * Метод для получения сообщения - вывода команды group_counting_by_chapter
     * @param chapter - определенная глава
     * @param sum - количество SpaceMarine на данной главе
     * @return String message
     */
    String getSumMarinesInChapterMessage(String chapter, Long sum);

    /**
     * Метод для получения сообщения о команде help
     * @return String message
     */
    String getInfoHelpMessage();

    /**
     * Метод для получения сообщения о команде insert_at
     * @return String message
     */
    String getInfoInsertAtMessage();

    /**
     * Метод для получения сообщения о команде remove_by_id
     * @return String message
     */
    String getInfoRemoveByIdMessage();

    /**
     * Метод для получения сообщения о команде reorder
     * @return String message
     */
    String getInfoReorderMessage();

    /**
     * Метод для получения сообщения о команде save
     * @return String message
     */
    String getInfoSaveMessage();

    /**
     * Метод для получения сообщения о команде show
     * @return String message
     */
    String getInfoShowMessage();

    /**
     * Метод для получения сообщения о команде sum_of_health
     * @return String message
     */
    String getInfoSumOfHealthMessage();

    /**
     * Метод для получения сообщения результата команды sum_of_health
     * @param sum - сумма здоровья
     * @return String message
     */
    String getPrintSumOfHealthMessage(Float sum);

    /**
     * Метод для получения сообщения о команде update_id
     * @return String message
     */
    String getInfoUpdateIdMessage();

    /**
     * Метод для получения сообщения о команде info
     * @return String message
     */
    String getInfoInfoMessage();

    /**
     * Метод для получения сообщения о данной коллекции
     * @param type - тип коллекции
     * @param date - дата создания
     * @param size - размер
     * @return String message
     */
    String getPrintInfo(String type, Date date, int size);
}
