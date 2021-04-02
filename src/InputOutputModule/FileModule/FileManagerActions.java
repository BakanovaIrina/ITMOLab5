package InputOutputModule.FileModule;

import CollectionModule.BaseClass.SpaceMarine;
import ExceptionModule.UncorrectedFileException;
import ExceptionModule.UncorrectedNullException;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Менеджер, отвечающий за ввод-вывод из файла
 */
public interface FileManagerActions {

    /**
     * Метод, получающий элементы из файла
     * @param fileName - имя файла
     * @return - лист элементов
     * @throws FileNotFoundException - файл не найден
     * @throws UncorrectedNullException - имя файла не введено
     * @throws UncorrectedFileException - файл некорректен
     */
    ArrayList<SpaceMarine> getCollectionFromFile(String fileName) throws FileNotFoundException,
            UncorrectedNullException, UncorrectedFileException;

    /**
     * Метод, записывающий элемент в файл
     * @param spaceMarines - записываемый элемент
     */
    void writeElements(ArrayList<SpaceMarine> spaceMarines);

    /**
     * Метод, получающий поток из файла
     * @param fileName - имя файла
     * @return - поток данных
     * @throws FileNotFoundException - файл не найден
     * @throws UncorrectedNullException - имя файла не введено
     * @throws UncorrectedFileException - файл некорректен
     */
    InputStreamReader getInputStreamForScript(String fileName) throws FileNotFoundException,
            UncorrectedNullException, UncorrectedFileException;

}
