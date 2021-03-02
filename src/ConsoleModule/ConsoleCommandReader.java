package ConsoleModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleCommandReader extends AbstractCommandReader{
    /**
     * Конструктор класса
     */
    public ConsoleCommandReader(){
        super(new BufferedReader( new InputStreamReader(System.in)));
    }

    /**
     *
     * @return введенное пользователем название команды
     * @throws IOException
     */
    public String read() throws IOException {
        String commandName = super.getReader().readLine();
        return commandName;
    }

}
