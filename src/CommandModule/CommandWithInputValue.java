package CommandModule;

/**
 * Интерфейс, помечающий команду, при которой нужно ввести какое-то значение
 */
public interface CommandWithInputValue {
    /**
     * Сеттер для значения
     * @param value - значение
     * @throws NumberFormatException - возникает, если пользователь ввел несоответствующее для данной команды
     * значение
     */
    void setValue(String value) throws NumberFormatException;
}
