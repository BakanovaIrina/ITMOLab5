package InputOutputModule.FileModule;

import CollectionModule.BaseClass.SpaceMarine;
import ExceptionModule.UncorrectedFieldException;
import ExceptionModule.UncorrectedFileException;
import ExceptionModule.UncorrectedNullException;
import ExceptionModule.UncorrectedSizeException;
import MessengerModule.Messenger;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Менеджер для работы с файлами
 */
public class FileManager implements FileManagerActions {

    /**
     * Читатель данных из файла
     */
    FileReaderActions fileReader;

    /**
     * Записыватель данных в файл
     */
    FileWriterActions fileWriter;

    /**
     * Примитивный парсер при получении данных
     */
    ParserActions parser;

    /**
     * Мессенджер для вывода сообщений
     */
    Messenger messenger;

    /**
     * Конструктор
     * @param fileReader - читатель
     * @param fileWriter - записыватель
     * @param parser - парсер
     * @param messenger - мессенджер
     */
    public FileManager(FileReaderActions fileReader, FileWriterActions fileWriter, ParserActions parser,
                       Messenger messenger) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.parser = parser;
        this.messenger = messenger;
    }

    @Override
    public ArrayList<SpaceMarine> getCollectionFromFile(String fileName) {
        ArrayList<SpaceMarine> spaceMarines = new ArrayList<>();
        ArrayList<String> input = null;
        try {
            input = fileReader.getStringFile(fileReader.openFile(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UncorrectedFileException | UncorrectedNullException e) {
            messenger.printErrorMessage(messenger.getUncorrectedFile());
        }

        for (String s : input) {
            try {
                spaceMarines.add(parser.parseToSpaceMarine(s));
            } catch (UncorrectedSizeException e) {
                messenger.printErrorMessage(messenger.getUncorrectedSize());
            } catch (ParseException | UncorrectedFieldException e) {
                messenger.printErrorMessage(messenger.getUncorrectedField());
            }
        }
        return spaceMarines;
    }

    @Override
    public void writeElements(ArrayList<SpaceMarine> spaceMarines) {
        for (SpaceMarine spaceMarine: spaceMarines) {
            String marine = parser.parseToCsv(spaceMarine);
            try {
                fileWriter.write(marine);
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                messenger.printErrorMessage(messenger.getUncorrectedFile());
            }
        }
    }

    @Override
    public InputStreamReader getInputStreamForScript(String fileName) throws FileNotFoundException,
            UncorrectedNullException, UncorrectedFileException {
        return fileReader.openFile(fileName);
    }

}
