package ex04_02;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    private DoubleProperty radius;
    private double _radius = 20;

    public double getRadius() {
        return (radius != null) ? radius.get() : _radius;
    }

    public void setRadius(double value) {
        if (radius != null) {
            radius.set(value);
        } else {
            _radius = value;
        }
    }

    public DoubleProperty radiusProperty() {
        if (radius == null) {
            radius = new SimpleDoubleProperty(this, "radius", _radius);
        }
        return radius;
    }
}
