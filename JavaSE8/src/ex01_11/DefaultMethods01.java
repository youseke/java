package ex01_11;

/**
 *
 * @author Tohtetsu Choh
 */
public class DefaultMethods01 {

    interface I {

        default public void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    interface J {

        default public void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    // コンパイラエラーになる
    class Test implements I, J {
    }
}
