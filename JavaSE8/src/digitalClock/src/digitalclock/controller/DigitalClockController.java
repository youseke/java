package digitalclock.controller;

import digitalclock.model.Clock;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author tohtetsu
 */
public class DigitalClockController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu file;
    @FXML
    private Menu tool;
    @FXML
    private MenuItem close;
    @FXML
    private MenuItem property;

    private Clock clock;
    private GridPane dialog;
    private Stage primaryStage, stage;

    final Delta dragDelta = new Delta();

    @FXML
    private void closeMenuItemAction() {
        ((Stage) mainPane.getScene().getWindow()).close();
    }

    @FXML
    private void propertyMenuItemAction() {
        stage.show();
    }

    @FXML
    private void handleOnMouseClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY) {
            stage.setX(event.getScreenX());
            stage.setY(event.getScreenY());
            stage.show();
        }
    }

    @FXML
    private void handleOnMousePressed(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            dragDelta.x = event.getSceneX();
            dragDelta.y = event.getSceneY();
            mainPane.setCursor(Cursor.MOVE);
        }
    }

    @FXML
    private void handelOnMouseDragged(MouseEvent event) {
        primaryStage.setX(event.getScreenX() - dragDelta.x);
        primaryStage.setY(event.getScreenY() - dragDelta.y);
    }

    @FXML
    private void handleOnMouseEntered(MouseEvent event) {
        if (primaryStage == null) {
            primaryStage = ((Stage) (mainPane.getScene().getWindow()));
        }
        mainPane.setCursor(Cursor.HAND);
    }

    @FXML
    private void handleOnMouseReleased(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            mainPane.setCursor(Cursor.HAND);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dialog = FXMLLoader.load(getClass().getResource("/digitalclock/view/Dialog.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DigitalClockController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage = ((Stage) dialog.getScene().getWindow());

        clock = new Clock(mainPane, menuBar, dialog);
        mainPane.getChildren().add(clock);

    }

    class Delta {

        double x, y;
    }
}
