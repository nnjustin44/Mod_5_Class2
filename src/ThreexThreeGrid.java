/* Justin Nguyen
Professor Sarah North
CS W01 Online 1302
MOD_5
 */







import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


    public class ThreexThreeGrid extends Application {

        @Override
        public void start(Stage primaryStage) {

            Pane pane = new Pane();
            primaryStage.setTitle("3x3 Grid");
            primaryStage.setScene(new Scene(pane, 400, 400));


            double divider = 3;
            for (int i = 0; i < 2; i++) {
                Line line = new Line();
                line.setStroke(Color.RED);
                line.startXProperty().bind(pane.widthProperty().divide(divider));
                line.startYProperty().bind(pane.layoutYProperty());
                line.endXProperty().bind(line.startXProperty());
                line.endYProperty().bind(pane.heightProperty());
                pane.getChildren().add(line);
                divider /= 2;
            }
            divider = 3;
            for (int i = 0; i < 2; i++) {
                Line line = new Line();
                line.setStroke(Color.BLUE);
                line.startXProperty().bind(pane.layoutXProperty());
                line.startYProperty().bind(pane.heightProperty().divide(divider));
                line.endXProperty().bind(pane.widthProperty());
                line.endYProperty().bind(pane.heightProperty().divide(divider));
                pane.getChildren().add(line);
                divider /= 2;
            }


            primaryStage.show();
        }

        public static void main(String[] args) {

            Application.launch(args);

        }
    }



