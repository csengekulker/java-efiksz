
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Graphics extends Application {
    public void start(Stage stage) {

        Group root = new Group();

        Scene scene = new Scene(root, 500, 500, Color.BLACK);

        Line line = new Line(0, 0, 0, 500);
        line.setStroke(Color.BLUE);
        root.getChildren().add(line);

        TranslateTransition tt = new TranslateTransition(
            Duration.millis(250),
            line
        );
        tt.setToX(500);
        tt.setToY(500);
        tt.setCycleCount(Timeline.INDEFINITE);
        tt.setAutoReverse(true);
        tt.play();

        // line 2

        Line line2 = new Line(0, 0, 500, 0);
        line2.setStroke(Color.RED);
        root.getChildren().add(line2);

        TranslateTransition tt2 = new TranslateTransition(
            Duration.millis(500),
            line2
        );

        tt2.setToX(500);
        tt2.setToY(500);
        tt2.setCycleCount(Timeline.INDEFINITE);
        tt2.setAutoReverse(true);
        tt2.play();

        stage.setTitle("javafx graphics");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
