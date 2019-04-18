/* Justin Nguyen
Professor Sarah North
CS W01 Online 1302
MOD_5
 */






import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Circle extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Call function drawCircle
        drawCircle(primaryStage);
    }
    private void drawCircle(Stage primaryStage)
    {
        // Craete new Pane
        Pane pan=new Pane();
        // Create new circle
        Circle cir=new Circle(300,300,30);
        // Fill circle with random color
        cir.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        // Create new slider
        Slider sldr = new Slider(0, 300,50);
        // Set tickmarks for slider
        sldr.setShowTickMarks(true);
        // Set tick labeles for slider
        sldr.setShowTickLabels(true);
        // Set the maximum width
        sldr.setMaxWidth(600);
        // Craete new text
        Text txt=new Text(50,50,"circle");
        // Set color for text
        txt.setFill(Color.RED);
        // Set property for slider
        sldr.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> oldVal, Number t, Number t1) {
                // Change radius
                double rad=t1.doubleValue();
                // Change text
                txt.setText("New Radius: " + rad);
                // Set radus for circle
                cir.setRadius(rad);
                // Fill the circle
                cir.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            }
        });
        // Add circle, text and slider to pan
        pan.getChildren().addAll(cir,txt,sldr);
        // Create new scene
        Scene scn=new Scene(pan,600,600);
        // Set title
        primaryStage.setTitle("Circle");
        // Set scene
        primaryStage.setScene(scn);
        // Show scene
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}