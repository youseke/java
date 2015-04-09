package ex08_12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    @Test
    public void perform() {
        Class clazz = Math.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            TestCase[] testCases = method.getAnnotationsByType(TestCase.class);
            assertTrue(testCases.length > 0);
            for (TestCase testCase : testCases) {
                assertEquals(testCase.expected(), Math.factorial(testCase.params()));
            }
        }
    }

    @Repeatable(TestCases.class)
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TestCase {

        int params();

        int expected();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface TestCases {

        TestCase[] value();
    }
}
