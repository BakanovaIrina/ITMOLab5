package ConsoleModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Класс для взаимодействия с файлами (чтение и проверка)
 */
public class ConsoleFileReader implements FileReader{

    @Override
    public boolean fileCheck(File file) {
            boolean passedCheck = true;
            if (!file.exists()) {
                System.out.println("Не удалось найти файл: " + file.getName());
                passedCheck = false;
            } else {
                if (!file.canRead()) {
                    System.out.println("Не удалось открыть файл для чтения: " + file.getName());
                    passedCheck = false;
                }
                if (!file.canWrite()) {
                    System.out.println("Не удалось открыть файл для записи: " + file.getName());
                    passedCheck = false;
                }
            }
            return passedCheck;
    }

    @Override
    public InputStreamReader openFile(String fileName) {
            File file;
            if (fileName != null){
                file = new File(fileName);
            }
            else {
                System.out.println("Вы ввели пустую строку");
                return null;
            }
            if (fileCheck(file)){
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
                    System.out.println("Открытие файла произведено корректно");
                    return inputStreamReader;
                } catch (FileNotFoundException e) {
                    System.out.println("Входной файл не может быть открыт");
                    return null;
                }
            }
            return null;
    }
}
