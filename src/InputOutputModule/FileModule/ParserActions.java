package InputOutputModule.FileModule;

import CollectionModule.BaseClass.SpaceMarine;
import ExceptionModule.UncorrectedFieldException;
import ExceptionModule.UncorrectedSizeException;

import java.text.ParseException;

/**
 * Интерфейс для примитивного парсера
 */
public interface ParserActions {
    /**
     * Метод, получающий из строки элемент SpaceMarine
     * @param input - строка элемента
     * @return - элемент SpaceMarine
     * @throws UncorrectedSizeException - бросается, если ввод не соответствует количеству требуемых полей
     * @throws ParseException - бросается при парсинге
     * @throws UncorrectedFieldException - бросается, если поле некорректно
     */
    SpaceMarine parseToSpaceMarine(String input) throws UncorrectedSizeException, ParseException,
            UncorrectedFieldException;

    /**
     * Метод, получающий из spaceMarine строку в формате csv
     * @param spaceMarine - элемент SpaceMarine
     * @return String spaceMarine
     */
    String parseToCsv(SpaceMarine spaceMarine);
}
