package ex01_11;

/**
 *
 * @author Tohtetsu Choh
 */
public class StaticMethods02 {

    interface J {

        public static void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    //　コンパイラエラーにならない
    class Test extends S implements J {
    }
}

class S {

    public static void f() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
