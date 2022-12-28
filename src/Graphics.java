
import javafx.animation.Interpolator;
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
        stage.setTitle("javafx graphics");
        stage.setScene(scene);

        Line line = new Line(0, 0, 0, 500);
        line.setStroke(Color.BLUE);
        root.getChildren().add(line);

        TranslateTransition tt = new TranslateTransition(
            Duration.millis(200),
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
        line2.setStrokeWidth(5);
        root.getChildren().add(line2);

        TranslateTransition tt2 = new TranslateTransition(
            Duration.millis(500),
            line2
        );

        tt2.setFromX(0);
        tt2.setFromY(500);
        tt2.setInterpolator(Interpolator.EASE_OUT);
        tt2 = setParams(tt2, 250, 250, Timeline.INDEFINITE, true);
        tt2.play();

        for (int i = 10; i < 50; i+=10) {
            tt2 = setParams(tt2, 250, 250, Timeline.INDEFINITE, true);
            tt2.setDelay(Duration.millis(350));
            tt2.play();
        }

        stage.show();
    }

    private TranslateTransition setParams(
        TranslateTransition tt,
        int toX, 
        int toY, 
        int cycleCount, 
        boolean isAutoReverse) {

        tt.setToX(toX);
        tt.setToY(toY);
        tt.setCycleCount(cycleCount);
        tt.setAutoReverse(isAutoReverse);

        return tt;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
