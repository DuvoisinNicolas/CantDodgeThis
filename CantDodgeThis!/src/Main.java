import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class Main extends Application {

    private IntegerProperty currentLevel = new SimpleIntegerProperty(1);
    private Pane root = new Pane();
    private Ball ball = new Ball();

    private ArrayList<ObstacleRectangle> tabObst = new ArrayList<>();

    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        initStage(primaryStage);
        root.getChildren().add(ball);
        primaryStage.show();

        prepareRectangles();
    }

    private void prepareRectangles() {
        do {
            tabObst.clear();
            tabObst.add(new ObstacleRectangle());
            tabObst.add(new ObstacleRectangle());
            tabObst.add(new ObstacleRectangle());
        }
        while (tabObst.get(0).getLayoutBounds().intersects(tabObst.get(1).getLayoutBounds())
                || tabObst.get(0).getLayoutBounds().intersects(tabObst.get(2).getLayoutBounds())
                || tabObst.get(1).getLayoutBounds().intersects(tabObst.get(2).getLayoutBounds()));


        for (ObstacleRectangle ob : tabObst) {
            root.getChildren().add(ob);
            Bounds bounds = root.getBoundsInLocal();
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5 - currentLevel.get()), new KeyValue(ob.posYProperty(), bounds.getMaxY() - ob.getHeight())));
            timeline.cycleCountProperty().bind(currentLevel);
            timeline.play();
        }
    }

    private void initStage(Stage primaryStage) {
        primaryStage.setTitle("Can't Dodge This !");
        primaryStage.setResizable(false);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setScene(new Scene(root,800,800));
    }

}
