package InputOutputModule.FileModule;

import java.io.*;
import java.util.ArrayList;

/**
 * Класс, взаимодействующий с файлом
 */
public class FileReader implements FileReaderActions{
    /**
     * Валидатор для проверки ввода
     */
    FileValidatorActions fileValidator;

    /**
     * Конструктор
     */
    public FileReader(){
        fileValidator = new FileValidator();
    }

    @Override
    public InputStreamReader openFile(String fileName) throws FileNotFoundException{
        if (fileValidator.validateFileName(fileName)){
            File file = new File(fileName);
            if (fileValidator.validateFile(file)){
                return new InputStreamReader(new FileInputStream(file));
            }
            else throw new FileNotFoundException();
        }
        else throw new FileNotFoundException();
    }

    @Override
    public ArrayList<String> getStringFile(InputStreamReader inputStreamReader) throws IOException {
        BufferedReader reader = new BufferedReader(inputStreamReader);
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            list.add(reader.readLine());
        }
        return list;
    }
}
