package ex04_10;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleBrowser extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("BrowserView.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Simple Browser");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}
