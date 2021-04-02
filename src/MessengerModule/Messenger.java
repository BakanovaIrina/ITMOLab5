package MessengerModule;

/**
 * Класс-предок всех Messengers
 */
public abstract class Messenger implements ExceptionMessages, AnotherMessenger, CommandsMessages,
        CollectionMessenger, InputMessenger{

    /**
     * Метод, выводящий сообщения
     * @param message - выводимое
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Метод, выводящий сообщения об ошибках
     * @param message - выводимое
     */
    public void printErrorMessage(String message){
        System.out.println(message);
    }
}
