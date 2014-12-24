package ex03_14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

class HighlyEnhancedLatentImage {

    Image image;
    List<HighlyEnhancedColorTransformer> pendingOperations;
    List<Color[][]> cache;

    public static HighlyEnhancedLatentImage from(Image in) {
        HighlyEnhancedLatentImage result = new HighlyEnhancedLatentImage();
        result.image = in;
        result.pendingOperations = new ArrayList<>();
        result.cache = new ArrayList<>();
        return result;
    }

    public HighlyEnhancedLatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(map(f));
        return this;
    }

    public HighlyEnhancedLatentImage transform(HighlyEnhancedColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        for (int i = 0; i < pendingOperations.size() - 1; i++) {
            cache.add(new Color[width][height]);
        }
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = image.getPixelReader().getColor(x, y);
                for (int i = 0; i < pendingOperations.size(); i++) {
                    HighlyEnhancedColorTransformer operation = pendingOperations.get(i);
                    c = operation.apply(x, y, new PixelReader(this, i));
                    if (i < pendingOperations.size() - 1 && cache.get(i)[x][y] == null) {
                        cache.get(i)[x][y] = c;
                    }
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }

    private HighlyEnhancedColorTransformer map(UnaryOperator<Color> op) {
        return (x, y, reader) -> op.apply(reader.get(x, y).get());
    }

}
