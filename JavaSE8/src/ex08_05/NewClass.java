package ex08_05;

import ex03.CommonUtil;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    @Test
    @Override
    public void perform() {
        ArrayList<String> words = new ArrayList<>(getWordsAsList());
        words.removeIf(w -> w.length() <= 12);
        assertEquals(33, words.size());
    }

}
