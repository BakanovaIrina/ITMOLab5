import ApplicationModule.Application;

/**
 * Main-класс
 * @author Ирина Баканова
 * version 2.0
 */
public class Main {
    /**
     * Метод, запускающий application
     * @param args - аргументы командной строки
     */
    public static void main(String[] args) {
         Application application = new Application();

         application.prepare(args);
         application.run();
    }
}
