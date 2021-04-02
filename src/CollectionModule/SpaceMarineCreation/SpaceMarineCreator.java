package CollectionModule.SpaceMarineCreation;

import CollectionModule.BaseClass.*;
import ExceptionModule.UncorrectedFieldException;

import java.util.Date;

/**
 * Класс для создания новых элементов SpaceMarine
 */
public class SpaceMarineCreator implements SpaceMarineCreatorActions {

    /**
     * Валидатор для полей
     */
    SpaceMarineValidatorActions validator;

    /**
     * Генератор id
     */
    GeneratorIdAction generatorId;

    /**
     * Конструктор
     * @param validator - валидатор
     * @param generatorId - генератор id
     */
    public SpaceMarineCreator(SpaceMarineValidatorActions validator, GeneratorId generatorId){
        this.validator = validator;
        this.generatorId = generatorId;
    }

    /**
     * Конструктор
     */
    public SpaceMarineCreator() {
        validator = new SpaceMarineValidator();
        generatorId = new GeneratorId();
    }

    @Override
    public int createNewId() {
        int id = generatorId.generateId();
        while (!validator.validateId(id)){
            id = generatorId.generateId();
        }
        return id;
    }

    @Override
    public Coordinates createCoordinates(float x, double y) throws UncorrectedFieldException {
        Coordinates coordinates;
        if (validator.validateCoordinates(x, y)){
            coordinates = new Coordinates(x, y);
        }
        else {
            throw new UncorrectedFieldException();
        }
        return coordinates;
    }

    @Override
    public Chapter createChapter(String chapterName, String parentLegion, int marinesCount) {
        Chapter chapter;
        if (validator.validateChapter(chapterName, parentLegion, marinesCount)){
            chapter = new Chapter(chapterName, parentLegion, marinesCount);
        }
        else
            chapter = null;
        return chapter;
    }

    @Override
    public SpaceMarine createSpaceMarine(String name, Coordinates coordinates, Date creationDate, float health,
                                         AstartesCategory astartesCategory, Weapon weapon,
                                         MeleeWeapon meleeWeapon, Chapter chapter) throws UncorrectedFieldException {
        if(validator.validateName(name) && validator.validateCoordinates(coordinates) &&
                validator.validateCreationDate(creationDate) && validator.validateHealth(health) &&
        validator.validateAstartesCategory(astartesCategory) && validator.validateWeapon(weapon) &&
        validator.validateMeleeWeapon(meleeWeapon)){
            int id = createNewId();
            SpaceMarine spaceMarine = new SpaceMarine(id, name, coordinates, creationDate, health, astartesCategory,
                    weapon, meleeWeapon, chapter);
            return spaceMarine;
        }
        else {
            throw new UncorrectedFieldException();
        }
    }
}
