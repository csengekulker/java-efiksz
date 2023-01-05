import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;

public class Bezier extends Application {

    public void start(Stage stage) {
        Group root = new Group();

        Scene scene = new Scene(root, 500, 500, Color.BLACK);

        

        for (int i = 0; i < 5; i++) {
            CubicCurve curve = new CubicCurve(
                    0, 0, // start
                    0, 60*i,
                    500, 40*i,
                    500, 500 // end
            );

            curve.setStroke(Color.WHITE);
            curve.setStrokeWidth(2);

            root.getChildren().add(curve);
        }

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
