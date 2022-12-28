import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Scaling extends Application{
    
    @Override
    public void start(Stage stage) {

        Group root = new Group();

        Scene scene = new Scene(root, 500, 500, Color.BLACK);

        Line left = new Line(0, 0, 250, 250);
        left.setStrokeWidth(2);
        left.setStroke(Color.rgb(255, 0, 0));

        Line right = new Line(500, 0, 250, 250);
        right.setStrokeWidth(2);
        right.setStroke(Color.rgb(0, 255, 0));

        root.getChildren().add(left);
        root.getChildren().add(right);

        stage.setScene(scene);
        stage = setStyle(StageStyle.TRANSPARENT);
        stage.setTitle("javafx square");
        stage.show();

    }

    private static Stage setStyle(StageStyle style) {
        
    }

    public static void main(String[] args) {
        // launch(args);

        Scaling.start(new Stage(StageStyle.TRANSPARENT));
    }
}
