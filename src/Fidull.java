import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Fidull extends Application {

  public void start(Stage stage) {
    Group root = new Group();

    Scene scene = new Scene(root, 500, 500, Color.BLACK);

    for (int i = 0; i < 100; i += 3) {
      Ellipse ellipse = new Ellipse(
          250,
          250,
          2 * i,
          i / 2);

      ellipse.setStrokeWidth(1);
      ellipse.setFill(Color.TRANSPARENT);
      ellipse.setStroke(Color.WHITE);

      if (i % 2 == 0) {
        FadeTransition ft = new FadeTransition(
            Duration.millis(500),
            ellipse);

        ft.setAutoReverse(true);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setFromValue(0);
        ft.setByValue(1);
        ft.play();

      } else if (i % 3 == 0) {
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), ellipse);
        st.setByX(.5f);
        st.setByY(2f);
        st.setCycleCount(Timeline.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
      } else {
        ScaleTransition st = new ScaleTransition(Duration.millis(2000), ellipse);
        st.setByX(2f);
        st.setByY(.5f);
        st.setCycleCount(Timeline.INDEFINITE);
        st.setAutoReverse(true);
        st.play();
      }

      root.getChildren().add(ellipse);
    }

    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
