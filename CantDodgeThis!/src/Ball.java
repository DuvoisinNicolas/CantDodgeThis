import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    private IntegerProperty posX = new SimpleIntegerProperty();
    private IntegerProperty posY = new SimpleIntegerProperty();
    private IntegerProperty radius = new SimpleIntegerProperty();


    public Ball ()
    {
        posX.set(400);
        posY.set(400);
        radius.set(10);
        this.setCenterX(posX.getValue());
        this.setCenterY(posY.getValue());
        this.setRadius(radius.getValue());
        this.setFill(Color.RED);
    }

}
