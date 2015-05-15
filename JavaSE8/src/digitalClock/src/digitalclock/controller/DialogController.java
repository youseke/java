package digitalclock.controller;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author tohtetsu
 */
public class DialogController implements Initializable {

    @FXML
    private GridPane gridPane;
    @FXML
    private ComboBox fontName;
    @FXML
    private ColorPicker color, backgroundColor;
    @FXML
    private Slider fontSize;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;

    private Color c, b;
    private String f;
    private Double s;

    @FXML
    private void okButtonAction() {
        ((Stage) gridPane.getScene().getWindow()).close();
    }

    @FXML
    private void cancelButtonAction() {
        fontName.setValue(f);
        color.setValue(c);
        backgroundColor.setValue(b);
        fontSize.setValue(s);
        ((Stage) gridPane.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(new Scene(gridPane));

        ObservableList<String> familiesObservableList = FXCollections.observableArrayList(Font.getFamilies());
        fontName.setItems(familiesObservableList);

        stage.setOnShowing((WindowEvent we) -> {
            storeValues();
        });
        stage.setOnCloseRequest((WindowEvent we) -> {

        });

        fontName.setValue(Font.getDefault().getName());
        fontSize.setValue(50);
        color.setValue(Color.BLACK);
        backgroundColor.setValue(Color.WHITE);
    }

    public void storeValues() {
        c = color.getValue();
        b = backgroundColor.getValue();
        f = (String) fontName.getValue();
        s = fontSize.getValue();
    }
}
