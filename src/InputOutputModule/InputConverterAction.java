package InputOutputModule;

import CollectionModule.BaseClass.*;

/**
 * Интерфейс, описывающий основные действия по конвертации строки в соответствующие поля
 */
public interface InputConverterAction {

    /**
     * Конвертация из строки в массив
     * @param s - строка
     * @return - массив с введенным (сама команда и возможное значение)
     */
    String[] convertToCommand(String s);

    /**
     * Конвертация из строки в строку (в ином виде)
     * @param s - строка
     * @return - конвертированная строка
     */
    String convertToString(String s);

    /**
     * Конвертация из строки в int
     * @param s - строка
     * @return - конвертированная строка
     * @throws NumberFormatException - кидается, если тип нельзя привести
     */
    int convertToInt(String s) throws NumberFormatException;

    /**
     * Конвертация из строки в float
     * @param s - строка
     * @return - конвертированная строка
     * @throws NumberFormatException - кидается, если тип нельзя привести
     */
    float convertToFloat(String s) throws NumberFormatException;

    /**
     * Конвертация из строки в double
     * @param s - строка
     * @return - конвертированная строка
     * @throws NumberFormatException - кидается, если тип нельзя привести
     */
    double convertToDouble(String s) throws NumberFormatException;

    /**
     * Конвертация из строки в AstartesCategory
     * @param s - строка
     * @return - конвертированная строка
     * @throws IllegalArgumentException - кидается, если тип нельзя привести
     */
    AstartesCategory convertToAstartesCategory(String s) throws IllegalArgumentException;

    /**
     * Конвертация из строки в MeleeWeapon
     * @param s - строка
     * @return - конвертированная строка
     * @throws IllegalArgumentException - кидается, если тип нельзя привести
     */
    MeleeWeapon convertToMeleeWeapon(String s) throws IllegalArgumentException;

    /**
     * Конвертация из строки в Weapon
     * @param s - строка
     * @return - конвертированная строка
     * @throws IllegalArgumentException - кидается, если тип нельзя привести
     */
    Weapon convertToWeapon(String s) throws IllegalArgumentException;
}
