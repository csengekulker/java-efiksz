import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
 
public class App extends Application {
    @Override
    public void start(Stage stage) {
        Text text = new Text("Java FX");
        VBox vbox = new VBox(text);

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300, Color.BLACK);

        Ellipse ellipse = new Ellipse(150, 150, 40, 40);
        root.getChildren().add(ellipse);

        FillTransition fl = new FillTransition(
            Duration.millis(3000), 
            ellipse, 
            Color.BLACK, 
            Color.GREEN
        );

        fl.setCycleCount(10);
        fl.setAutoReverse(true);
        fl.play();


        stage.setScene(scene);
        stage.setTitle("mas");
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
