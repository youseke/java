package ex04_03;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    private static final double DEFAULT_RADIUS = 20;
    private DoubleProperty radius;

    public double getRadius() {
        return (radius != null) ? radius.get() : DEFAULT_RADIUS;
    }

    public void setRadius(double value) {
        if ((radius != null) || (value != DEFAULT_RADIUS)) {
            radiusProperty().set(value);
        }
    }

    public DoubleProperty radiusProperty() {
        if (radius == null) {
            radius = new SimpleDoubleProperty(this, "radius", DEFAULT_RADIUS);
        }
        return radius;
    }
}
