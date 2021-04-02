package CollectionModule.BaseClass;

/**
 * Класс координат
 */
public class Coordinates {

    //Значение поля должно быть больше -341, Поле не может быть null
    private Float x;

    //Значение поля должно быть больше -539, Поле не может быть null
    private Double y;

    public Coordinates(float x, double y){
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public Double getY() {
        return y;
    }
}
