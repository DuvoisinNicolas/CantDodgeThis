import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private BorderPane root = new BorderPane();
    private Ball ball = new Ball();
    private ObstacleRectangle obsRect = new ObstacleRectangle();

    public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            initStage(primaryStage);
            root.getChildren().addAll(obsRect,ball);
            primaryStage.show();
        }

    private void initStage(Stage primaryStage) {
        primaryStage.setTitle("Can't Dodge This !");
        primaryStage.setResizable(false);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setScene(new Scene(root,800,800));
    }

}
