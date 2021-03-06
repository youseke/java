package ex09_08;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NewClass {
    @Test
    public void perform() {
        Point a = new Point(Integer.MAX_VALUE, 8);
        Point b = new Point(-100, 8);
        assertTrue(a.compareTo(b) > 0);
        Point c = new Point(-Integer.MAX_VALUE, 8);
        Point d = new Point(100, 8);
        assertTrue(c.compareTo(d) < 0);
    }

    class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            int diff;
            try {
                diff = Math.subtractExact(x, other.x);
            } catch (ArithmeticException e) {
                return x;
            }
            if (diff != 0) return diff;
            try {
                return Math.subtractExact(y, other.y);
            } catch (ArithmeticException e) {
                return y;
            }
        }
    }

}
