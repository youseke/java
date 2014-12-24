package ex03_13;

import ex03_05.ColorTransformer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author Tohtetsu Choh
 */
class EnhancedLatentImage {

    private class TransformOperation {

        EnhancedColorTransformer transformer;
        boolean eager;

        private TransformOperation(EnhancedColorTransformer transformer) {
            this.transformer = transformer;
        }

        private TransformOperation(EnhancedColorTransformer transformer, boolean eager) {
            this.transformer = transformer;
            this.eager = eager;
        }
    }

    private Image in;
    private List<TransformOperation> pendingOperations;
    List<Color[][]> stages;

    public static EnhancedLatentImage from(Image in) {
        EnhancedLatentImage result = new EnhancedLatentImage();
        result.in = in;
        result.pendingOperations = new ArrayList<>();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        result.stages = new ArrayList<>();
        Color[][] initStage = new Color[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                initStage[x][y] = in.getPixelReader().getColor(x, y);
            }
        }
        result.stages.add(initStage);
        return result;
    }

    public EnhancedLatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(new TransformOperation(map(f)));
        stages.add(new Color[(int) in.getWidth()][(int) in.getHeight()]);
        return this;
    }

    public EnhancedLatentImage transform(ColorTransformer f) {
        pendingOperations.add(new TransformOperation(map(f)));
        stages.add(new Color[(int) in.getWidth()][(int) in.getHeight()]);
        return this;
    }

    public EnhancedLatentImage transform(EnhancedColorTransformer f) {
        pendingOperations.add(new TransformOperation(f, true));
        stages.add(new Color[(int) in.getWidth()][(int) in.getHeight()]);
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int i = pendingOperations.size() - 1; i > 0; i--) {
            TransformOperation o = pendingOperations.get(i);
            if (o.eager) {
                compute(pendingOperations.subList(0, i));
                break;
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (int i = 0; i < pendingOperations.size(); i++) {
                    TransformOperation o = pendingOperations.get(i);
                    if (i < pendingOperations.size()) {
                        Color[][] nextStage = stages.get(i + 1);
                        if (nextStage[x][y] == null) {
                            c = o.transformer.apply(x, y, stages.get(i));
                            nextStage[x][y] = c;
                        }
                    }
                }
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }

    private EnhancedColorTransformer map(UnaryOperator<Color> op) {
        return (x, y, colors) -> op.apply(colors[x][y]);
    }

    private EnhancedColorTransformer map(ColorTransformer op) {
        return (x, y, colors) -> op.apply(x, y, colors[x][y]);
    }

    private void compute(List<TransformOperation> operations) {
        for (int i = 0; i < operations.size(); i++) {
            TransformOperation o = operations.get(i);
            int width = (int) in.getWidth();
            int height = (int) in.getHeight();
            Color[][] stage = new Color[width][height];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    stage[x][y] = o.transformer.apply(x, y, stages.get(i));
                }
            }
            stages.set(i + 1, stage);
        }
    }
}
