package CollectionModule;

import java.util.Random;

/**
 * Интерфейс, генерирующий случайное значение поля id
 */
interface Generator {
    /**
     * Метод, генерирующий id
     * @return id
     */
    static int generateId(){
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
