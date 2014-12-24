package ex03_14;

import java.util.Optional;
import javafx.scene.paint.Color;

/**
 *
 * @author Tohtetsu Choh
 */
public class PixelReader {

    HighlyEnhancedLatentImage latentImage;
    int level;

    PixelReader(HighlyEnhancedLatentImage latentImage, int level) {
        this.latentImage = latentImage;
        this.level = level;
    }

    public Optional<Color> get(int x, int y) {
        if (x < 0 || x >= latentImage.image.getWidth() || y < 0 || y >= latentImage.image.getHeight()) {
            return Optional.empty();
        }
        if (level == 0) {
            return Optional.of(latentImage.image.getPixelReader().getColor(x, y));
        }
        Color[][] levelCache = latentImage.cache.get(level - 1);
        if (levelCache[x][y] != null) {
            return Optional.of(levelCache[x][y]);
        }
        levelCache[x][y] = latentImage.pendingOperations.get(level - 1).apply(x, y, new PixelReader(latentImage, level - 1));
        return Optional.of(levelCache[x][y]);
    }
}
