package CommandModule;

import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс, хранящий в себе карты доступных команд
 */
public abstract class AbstractCommandManager implements CommandManagerDoings{
    /**
     * Карта для всех команд
     */
    private final HashMap<String, Command> map;
    /**
     * Карта для команд, к которым дополнительно вводится какое-то поле
     */
    private final HashMap<String, Command> mapCommandsWithInputValue;

    /**
     * Конструктор класса, который заполняет обе карты
     * @param map - карта всех команд
     */
    AbstractCommandManager(HashMap<String, Command> map){
        this.map = map;
        this.mapCommandsWithInputValue = new HashMap<>();
        for (Map.Entry entry: map.entrySet()){
            if(entry.getValue() instanceof CommandWithInputValue){
                String name = (String)entry.getKey();
                String[] names = name.split(" ");
                mapCommandsWithInputValue.put(names[0], (Command) entry.getValue());
            }
        }
    }

    public HashMap<String, Command> getMap() {
        return map;
    }

    public HashMap<String, Command> getMapCommandsWithInputValue() {
        return mapCommandsWithInputValue;
    }
}
