
package ex04_06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
        BorderPane p = new BorderPane();
        Button top = new Button("Top");
        Button bottom = new Button("Bottom");
        p.setTop(top);
        BorderPane.setAlignment(top, Pos.TOP_CENTER);
        p.setLeft(new Button("Left"));
        p.setCenter(new Button("Center"));
        p.setRight(new Button("Right"));
        p.setBottom(bottom);
        BorderPane.setAlignment(bottom, Pos.BOTTOM_CENTER);
        primaryStage.setScene(new Scene(p));
        primaryStage.show();
    }
}
