package ex04_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass extends Application {
    
    public static void main(String... args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label message = new Label("Hello, FX");
        message.setFont(new Font(100));
        TextField text = new TextField("Hello, FX");
        message.textProperty().bind(text.textProperty());
        Pane pane = new VBox(message, text);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
    
}
