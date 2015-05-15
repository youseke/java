package digitalclock.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Tohtetsu Choh
 */
public class Clock extends Parent {

    private final Calendar calendar = Calendar.getInstance();
    private final StringProperty timeString = new SimpleStringProperty();
    private final ObjectProperty<Font> font = new SimpleObjectProperty<>(Font.getDefault());
    private final DoubleProperty layoutX = new SimpleDoubleProperty();
    private final DoubleProperty layoutY = new SimpleDoubleProperty();
    private final ObjectProperty<Background> background = new SimpleObjectProperty<>();

    private final Label label = new Label();
    private final AnchorPane pane;
    private final MenuBar menuBar;
    private final GridPane dialog;
    private final ComboBox box;
    private final ColorPicker color, backgroundColor;
    private final Slider fontSize;
    private double height, width = 0.0;

    public Clock(Node... nodes) {
        pane = (AnchorPane) nodes[0];
        menuBar = (MenuBar) nodes[1];
        dialog = (GridPane) nodes[2];
        box = (ComboBox) dialog.getChildren().get(4);
        color = (ColorPicker) dialog.getChildren().get(5);
        backgroundColor = (ColorPicker) dialog.getChildren().get(6);
        fontSize = (Slider) dialog.getChildren().get(7);

        label.textProperty().bind(timeString);
        label.fontProperty().bind(font);
        label.layoutXProperty().bind(layoutX);
        label.layoutYProperty().bind(layoutY);
        label.textFillProperty().bind(color.valueProperty());

        pane.backgroundProperty().bind(background);
        pane.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (pane.getHeight() < height * 1.5 + menuBar.getHeight()) {
                pane.getScene().getWindow().setHeight(height * 1.5 + menuBar.getHeight());
            }
        });
        pane.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (pane.getWidth() < width * 1.5) {
                pane.getScene().getWindow().setWidth(width * 1.5);;
            }
        });

        getChildren().add(label);
        refreshClocks();
        play();
    }

    private void refreshClocks() {
        //Display time
        calendar.setTimeInMillis(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String now = simpleDateFormat.format(calendar.getTime());
        timeString.setValue(now);
        Text text = new Text(now);
        text.setFont(font.getValue());
        width = text.getLayoutBounds().getWidth();
        height = text.getLayoutBounds().getHeight();
        //Layout
        layoutX.setValue((pane.getWidth() - width) / 2);
        layoutY.setValue((pane.getHeight() - menuBar.getHeight() - height) / 2 + menuBar.getHeight());
        //Font&Background Color
        background.setValue(new Background(new BackgroundFill(backgroundColor.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
        font.setValue(new Font((String) box.getValue(), fontSize.getValue()));
    }

    public final void play() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), (ActionEvent actionEvent) -> {
                    refreshClocks();
                }),
                new KeyFrame(Duration.millis(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
