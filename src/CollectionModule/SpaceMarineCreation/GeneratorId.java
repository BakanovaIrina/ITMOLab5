package CollectionModule.SpaceMarineCreation;

import java.util.Random;

/**
 * Класс-генератор id
 */
public class GeneratorId implements GeneratorIdAction {
    @Override
    public int generateId() {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
