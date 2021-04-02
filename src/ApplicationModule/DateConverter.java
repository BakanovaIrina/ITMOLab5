package ApplicationModule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс для конвертирования даты
 */
public class DateConverter implements DateConverterActions {

    /**
     * Красивый формат даты
     */
    private final SimpleDateFormat dateFormat;

    /**
     * Конструктор
     * @param dateFormat формат
     */
    public DateConverter(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String convertDateToStringFormat(Date date) {
        return dateFormat.format(date);
    }

    @Override
    public Date convertStringToDate(String date) throws ParseException {
        return dateFormat.parse(date);
    }
}
