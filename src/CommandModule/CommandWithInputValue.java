package CommandModule;

/**
 * Интерфейс, помечающий команды, для использования которых нужно ввести название команды
 * и определенное значение
 */
public interface CommandWithInputValue {

    /**
     * Метод, задающий значение для определенного значения
     * @param value - поле дополнительного аргумента
     */
    void setValue(String value);
}
