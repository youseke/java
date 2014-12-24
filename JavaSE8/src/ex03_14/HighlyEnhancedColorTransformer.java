package ex03_14;

import javafx.scene.paint.Color;

@FunctionalInterface
interface HighlyEnhancedColorTransformer {

    Color apply(int x, int y, PixelReader reader);
}
