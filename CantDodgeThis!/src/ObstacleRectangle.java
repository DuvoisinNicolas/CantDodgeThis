import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

public class ObstacleRectangle extends Rectangle {
    private IntegerProperty hauteur = new SimpleIntegerProperty();
    private IntegerProperty longueur = new SimpleIntegerProperty();
    private IntegerProperty posX = new SimpleIntegerProperty();
    private Translate translate;

    public ObstacleRectangle () {
        posX.set((int)(Math.random() * (800)));
        longueur.set(100+(int)(Math.random() * (400-100)));
        hauteur.set(100+(int)(Math.random() * (400-200)));
        this.setHeight(hauteur.getValue());
        this.setWidth(longueur.getValue());
        this.setX(posX.getValue());
        this.setY(0);
        translate= new Translate(posX.getValue(),1000);
        this.getTransforms().add(translate);
        this.setFill(Color.BLUE);
    }
}
