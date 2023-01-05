import java.util.ArrayList;

import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Draw extends Application {

    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<TranslateTransition> moves = new ArrayList<>();

    Line diagonal;
    Line horizontal;
    Line vertical;
    TranslateTransition tt;
    TranslateTransition htt;

    @Override
    public void start(Stage stage) {

        Group root = new Group();

        Scene scene = new Scene(root, 500, 500, Color.BLACK);

        final int padding = 10;

        for (int i = 1; i < 11; i++){
            Rectangle rect = new Rectangle(
                10*i, 10*i,
                (scene.getWidth() / i) - padding,
                (scene.getHeight() / i) - padding
            );

            System.out.println(rect.getWidth() + "|" + rect.getHeight());

            rect.setStrokeWidth(1);
            rect.setStroke(Color.WHITE);
            rect.setFill(Color.TRANSPARENT);

            TranslateTransition tt = new TranslateTransition(
                Duration.millis(1000),
                rect
            );

            tt.setAutoReverse(true);
            tt.setCycleCount(4);
            tt.setFromX(rect.getX());
            tt.setFromY(rect.getY());
            tt.setToX(scene.getWidth() - rect.getX());
            tt.setToY(scene.getHeight() - rect.getY());
            // tt.play();

            root.getChildren().add(rect);  
        
        }

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
