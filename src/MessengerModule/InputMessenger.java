package MessengerModule;

/**
 * Интерфейс для получения сообщений, связанных с вводом данных
 */
interface InputMessenger {

    /**
     * Метод для получения сообщения о вводе имени
     * @return String message
     */
    String getInputNameMessage();

    /**
     * Метод для получения сообщения о вводе координаты X
     * @return String message
     */
    String getInputCoordinateXMessage();

    /**
     * Метод для получения сообщения о вводе координаты Y
     * @return String message
     */
    String getInputCoordinateYMessage();

    /**
     * Метод для получения сообщения о вводе здоровья
     * @return String message
     */
    String getInputHealthMessage();

    /**
     * Метод для получения сообщения о вводе категории
     * @return String message
     */
    String getInputCategoryMessage();

    /**
     * Метод для получения сообщения о вводе оружия
     * @return String message
     */
    String getInputWeaponMessage();

    /**
     * Метод для получения сообщения о вводе оружия ближнего боя
     * @return String message
     */
    String getInputMeleeWeaponMessage();

    /**
     * Метод для получения сообщения о вводе названия главы
     * @return String message
     */
    String getInputChapterNameMessage();

    /**
     * Метод для получения сообщения о вводе родительского легиона
     * @return String message
     */
    String getInputParentLegionMessage();

    /**
     * Метод для получения сообщения о вводе количества spaceMarine в главе
     * @return String message
     */
    String getInputNumberOfMarinesMessage();

    /**
     * Метод для получения сообщения о существующих категориях
     * @return String message
     */
    String getEnumCategoryMessage();

    /**
     * Метод для получения сообщения о существующих типах оружия
     * @return String message
     */
    String getEnumWeaponMessage();

    /**
     * Метод для получения сообщения о существующих типах оружия ближнего боя
     * @return String message
     */
    String getEnumMeleeWeaponMessage();
}
