package ex03_13;

import javafx.scene.paint.Color;

/**
 *
 * @author Tohtetsu Choh
 */
@FunctionalInterface
public interface EnhancedColorTransformer {

    Color apply(int x, int y, Color[][] colors);
}
