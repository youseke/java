package ex04_04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass extends Application {

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle c = new Circle();
        c.setFill(Color.BLUE);
        Pane p = new Pane(c);
        Scene s = new Scene(p);
        c.centerXProperty().bind(Bindings.divide(s.widthProperty(), 2));
        c.centerYProperty().bind(Bindings.divide(s.heightProperty(), 2));
        c.radiusProperty().bind(Bindings.min(Bindings.divide(s.widthProperty(), 2), Bindings.divide(s.heightProperty(), 2)));
        primaryStage.setScene(s);
        primaryStage.show();
    }

}
