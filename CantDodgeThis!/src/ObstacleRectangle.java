import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class ObstacleRectangle extends Rectangle {
    private IntegerProperty longueur = new SimpleIntegerProperty();
    private IntegerProperty posX = new SimpleIntegerProperty();
    private IntegerProperty posY = new SimpleIntegerProperty();
    private ArrayList<Color> tabCouleurs = new ArrayList<>();

    public ObstacleRectangle () {
        posX.set((int)(Math.random() * (800)));
        longueur.set(100+(int)(Math.random() * (100-50)));
        heightProperty().set(200);
        this.widthProperty().bind(longueur);
        this.xProperty().bind(posX);
        this.posY.set(0);
        this.posY.bindBidirectional(yProperty());
        tabCouleurs.add(Color.BLUE);
        tabCouleurs.add(Color.RED);
        tabCouleurs.add(Color.GREEN);
        tabCouleurs.add(Color.YELLOW);

        this.setFill(tabCouleurs.get((int)(Math.random()*tabCouleurs.size())));
    }

    public IntegerProperty posYProperty() {
        return posY;
    }
}
