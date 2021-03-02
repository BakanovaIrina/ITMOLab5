package ConsoleModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс, осуществляющий ввод полей для создания (или добавления) нового элемента
 */
public class ConsoleFieldReader extends AbstractConsoleFieldReader {

    /**
     * Конструктор
     */
    public ConsoleFieldReader(){
        super(new BufferedReader( new InputStreamReader(System.in)));
    }

    @Override
    public int readInt() throws IOException, NumberFormatException {
        return Integer.parseInt(super.getReader().readLine());
    }

    @Override
    public float readFloat() throws IOException, NumberFormatException{
        return Float.parseFloat(super.getReader().readLine());
    }

    @Override
    public double readDouble() throws IOException, NumberFormatException {
        return Double.parseDouble(super.getReader().readLine());
    }

    @Override
    public String readString() throws IOException {
        return super.getReader().readLine();
    }
}
