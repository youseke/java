package ex03_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Optional;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Image image = new Image("src/main/resources/bunny.jpg");
            Image finalImage = HighlyEnhancedLatentImage.from(image)
                    .transform(Color::brighter)
                    .transform(blur())
                    .transform(edgeDetection())
                    .transform(frame(image))
                    .toImage();
            stage.setScene(new Scene(new HBox(
                    new ImageView(image),
                    new ImageView(finalImage))));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HighlyEnhancedColorTransformer blur() {
        return (x, y, reader) -> {
            double r = 0;
            double g = 0;
            double b = 0;
            int counter = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    Optional<Color> colorOptional = reader.get(x + i, y + j);
                    if (colorOptional.isPresent()) {
                        Color c = colorOptional.get();
                        r += c.getRed();
                        g += c.getGreen();
                        b += c.getBlue();
                        counter++;
                    }
                }
            }
            return Color.color(r / counter, g / counter, b / counter);
        };
    }

    private HighlyEnhancedColorTransformer edgeDetection() {
        Color nullColor = Color.color(0.0, 0.0, 0.0);
        return (x, y, reader) -> {
            Color c = reader.get(x, y).get();
            Color n = reader.get(x, y - 1).orElse(nullColor);
            Color e = reader.get(x + 1, y).orElse(nullColor);
            Color s = reader.get(x, y + 1).orElse(nullColor);
            Color w = reader.get(x - 1, y).orElse(nullColor);
            double r = 4 * c.getRed() - n.getRed() - e.getRed() - s.getRed() - w.getRed();
            double g = 4 * c.getGreen() - n.getGreen() - e.getGreen() - s.getGreen() - w.getGreen();
            double b = 4 * c.getBlue() - n.getBlue() - e.getBlue() - s.getBlue() - w.getBlue();
            return Color.color(
                    r < 0 ? 0.0 : r > 1 ? 1.0 : r,
                    g < 0 ? 0.0 : g > 1 ? 1.0 : g,
                    b < 0 ? 0.0 : b > 1 ? 1.0 : b
            );
        };
    }

    private HighlyEnhancedColorTransformer frame(Image image) {
        return (x, y, reader) -> (x <= 5 || x >= image.getWidth() - 5
                || y <= 5 || y >= image.getHeight() - 5) ? Color.WHITE : reader.get(x, y).get();
    }

}
