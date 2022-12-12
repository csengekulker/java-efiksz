import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
 
public class App extends Application {
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("mas");
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
