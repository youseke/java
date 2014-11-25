package ex03_05;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {
    public static void main(String... args){
        Image in = new Image("example.jpg");
    }
    
    public static void addFrame(Image in, ColorTransformer tran){
        tran.transform(in, Color.GRAY);
    }
}
