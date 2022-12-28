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

        this.diagonal = new Line(0, 0, 266, 266);
        diagonal.setStroke(Color.rgb(60, 170, 140));
        diagonal.setStrokeWidth(2);

        this.tt = new TranslateTransition(Duration.millis(2000));

        this.tt.setInterpolator(Interpolator.EASE_BOTH);
        this.tt = setParams(
                this.tt,
                this.diagonal.getEndX(),
                this.diagonal.getEndY(),
                this.diagonal.getStartX(),
                this.diagonal.getStartY(),
                Timeline.INDEFINITE,
                Duration.ONE,
                true);

        tt.setNode((Node) diagonal);
        root.getChildren().add(diagonal);

        tt.play();


        this.horizontal = new Line(0, 50, 512, 50);
        horizontal.setStroke(Color.rgb(255, 9, 43));
        horizontal.setStrokeWidth(2);

        this.htt = new TranslateTransition(Duration.millis(1000));
        htt.setNode((Node) horizontal);

        htt = setParams(htt, 250, 50, 512, 50, Timeline.INDEFINITE, Duration.ONE, true);

        root.getChildren().add(horizontal);

        htt.play();

        this.vertical = new Line(50, 250, 50, 500);
        vertical.setStroke(Color.rgb(30, 210, 76));
        vertical.setStrokeWidth(2);

        stage.setScene(scene);
        stage.setTitle("javafx draw");
        stage.show();

    }

    private TranslateTransition setParams(
            TranslateTransition tt,
            double fromX,
            double fromY,
            double toX,
            double toY,
            int cycleCount,
            Duration cycleDuration,
            boolean isAutoReverse) {

        tt.setFromX(fromX);
        tt.setFromY(fromY);
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
