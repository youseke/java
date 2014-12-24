package ex03_05;

import javafx.scene.paint.Color;

/**
 *
 * @author Tohtetsu Choh
 */
@FunctionalInterface
public interface ColorTransformer {

    Color apply(int x, int y, Color colorAtXY);
}
