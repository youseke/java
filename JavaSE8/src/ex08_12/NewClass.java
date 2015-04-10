package ex08_12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

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
    
    static class Math {

        @TestCase(params = 4, expected = 24)
        @TestCase(params = 0, expected = 1)
        public static int factorial(int n) {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}
