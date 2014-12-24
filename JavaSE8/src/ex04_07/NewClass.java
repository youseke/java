package ex04_07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        Label label = new Label("Test");
        label.setBorder(new Border(
                new BorderStroke(
                        Color.web("0xd62645"),
                        BorderStrokeStyle.SOLID,
                        null,
                        new BorderWidths(4))));
        pane.setCenter(label);
        stage.setScene(new Scene(pane));
        stage.show();
    }

}
