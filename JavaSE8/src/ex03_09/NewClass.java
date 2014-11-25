package ex03_09;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static Comparator<Object> lexicographicComparator(String... fieldNames) {
        return (Object o1, Object o2) -> {
            int result = 0;
            try {
                for (String fieldName : fieldNames) {
                    Field field = o1.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    String field1 = (String) field.get(o1);
                    String field2 = (String) field.get(o2);
                    result = field1.compareTo(field2);
                    if (result != 0) {
                        break;
                    }
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return result;
        };
    }

    static class Test {

        String lastName;
        String firstName;

        public Test(String lastName, String firstName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }

        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String... args) {
        System.out.println("Exercise 9");

        List<Test> tests = Arrays.asList(new Test("Test", "Test"), new Test("Chesters", "Daniel"));
        tests.sort(lexicographicComparator("lastName", "firstName"));
        tests.forEach(System.out::println);
    }
}
