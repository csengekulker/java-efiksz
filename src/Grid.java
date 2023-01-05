
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Grid extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    
    Group root = new Group();

    Scene scene = new Scene(root, 500, 500, Color.BLACK);

    final double wide = scene.getWidth();
    final double tall = scene.getHeight();

    for (int i=0; i<=wide; i+=this.x_inc) {

      Line line = new Line(
        i, i, // O
        
      );
    }

    stage.setScene(scene);
    stage.show();
    
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
