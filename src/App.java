import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

 
public class App extends Application {
    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300, Color.BLACK);
        Rectangle bg = new Rectangle(300, 300);

        Ellipse ellipse1 = new Ellipse(150, 150, 80, 40);
        Ellipse ellipse2 = new Ellipse(150, 150, 40, 80);

        ellipse1.setFill(Color.WHITE);
        ellipse2.setFill(Color.BLACK);

        Shape result = Shape.union(ellipse1, ellipse2);
        
        root.getChildren().add(bg);
        // root.getChildren().add(ellipse1);
        // root.getChildren().add(ellipse2);

        root.getChildren().add(result);

        FillTransition rootfill = new FillTransition(
            Duration.millis(3000),
            bg,
            Color.BLACK,
            Color.rgb(80, 160, 70)
        );

        FillTransition fl = new FillTransition(
            Duration.millis(100), 
            ellipse1, 
            Color.BLACK, 
            Color.GREEN
        );

        FillTransition fl2 = new FillTransition(
            Duration.millis(100),
            ellipse2,
            Color.BLACK,
            Color.GREENYELLOW
        );

        rootfill.setCycleCount(Timeline.INDEFINITE);
        rootfill.setAutoReverse(true);
        rootfill.play();

        fl.setCycleCount(Timeline.INDEFINITE);
        fl.setAutoReverse(true);
        fl.play();

        fl2.setCycleCount(Timeline.INDEFINITE);
        fl2.setAutoReverse(true);
        fl2.play();


        stage.setScene(scene);
        stage.setTitle("mas");
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
