import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collection;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Lanes extends Application {

    Scene scene;
    Collection<Node> rootBase;
    Group root;
    Dimension2D d2d;

    ArrayList<Node> laneNodes;

    ArrayList<Node> verticals;
    ArrayList<Node> horizontals;

    private ArrayList<Node> makeCols(double width, int lanes) {

        this.verticals = new ArrayList<Node>();

        // while i startY point fits window width
        for (int i=0; i < (width * lanes); i += width) {
            Line lane = new Line(
                i, // startX
                0, // startY - const
                width, // endX
                d2d.getHeight() // endY - const
            );

            // scale to desired dimensions
            lane.setScaleX(width);
            lane.setScaleY(d2d.getHeight());

            // styles 
            lane.setFill(Color.BLUE);
            lane.setStrokeWidth(3);
            lane.setStroke(Color.WHITE);

            verticals.add(lane);
            // verticals.add((Node) lane);
        }

        return verticals;
    }

    private ArrayList<Node> makeRows(double height, int lanes) {

        ArrayList<Node> horizontals = new ArrayList<Node>();

        Line lane;

        System.out.println(height + lanes);

        // while i startX point fits window height
        for ( int i=0; i < (height * lanes); i += height) {
            lane = new Line(
                    0, // startX - const
                    i, // startY
                    d2d.getWidth(), // endX - const
                    height // endY
            );

            // increase i by one lane's height
            System.out.println(i);

            // scale to desired dimensions
            // lane.setScaleX(d2d.getWidth());
            // lane.setScaleY(height);

            // styles 
            lane.setFill(Color.RED);
            lane.setStrokeWidth(3);
            lane.setStroke(Color.GREEN);

            // this.root.getChildren().add(lane);
            horizontals.add(lane);
        }

        return horizontals;
    }

    private ArrayList<Node> makeLaneNodes(int lanes, String align, Dimension2D d) {

        this.laneNodes = new ArrayList<Node>();

        System.out.println(d2d.getWidth()); // 500.0

        double laneWidth = d2d.getWidth() / lanes;
        double laneHeight = d2d.getHeight() / lanes;
 
        System.out.println(laneHeight); // 100.0

        System.out.println(align); // row

        switch (align) {
            case "row":
                System.out.println(lanes);
                laneNodes = makeRows(laneHeight, lanes);
            case "col":
                laneNodes = makeCols(laneWidth, lanes);
            default:
                break;
        }

        return laneNodes;
    }

    @Override
    public void start(Stage stage) {

        this.d2d = new Dimension2D(500, 500);

        this.rootBase = (Collection<Node>) makeLaneNodes(20, "row", this.d2d);

        this.root = new Group(rootBase);
        // Group horizontalLineGroup = new Group((Collection<Node>) makeLaneNodes(10, "col"));

        this.scene = new Scene(
            root,
            d2d.getWidth(),
            d2d.getHeight(),
            Color.BLACK
        );

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}