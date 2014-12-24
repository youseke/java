package ex03_13;

import ex03_05.ColorTransformer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass extends Application {

    public void start(Stage stage) {
        try {
            Image image = new Image("queen-mary.png");
            Image finalImage = EnhancedLatentImage.from(image)
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

    private EnhancedColorTransformer blur() {
        return (x, y, colors) -> {
            double r = 0;
            double g = 0;
            double b = 0;
            int counter = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (x + i >= 0 && y + j >= 0 && x + i < colors.length && y + j < colors[x + i].length) {
                        Color c = colors[x + i][y + j];
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

    private EnhancedColorTransformer edgeDetection() {
        Color nullColor = Color.color(0.0, 0.0, 0.0);
        return (x, y, colors) -> {
            Color c = colors[x][y];
            Color n = y > 0 ? colors[x][y - 1] : nullColor;
            Color e = x < colors.length - 1 ? colors[x + 1][y] : nullColor;
            Color s = y < colors[y].length - 1 ? colors[x][y + 1] : nullColor;
            Color w = x > 0 ? colors[x - 1][y] : nullColor;
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

    private ColorTransformer frame(Image image) {
        return (x, y, c) -> (x <= 5 || x >= image.getWidth() - 5
                || y <= 5 || y >= image.getHeight() - 5) ? Color.WHITE : c;
    }

}
