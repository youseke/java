package ex01_11;

/**
 *
 * @author Tohtetsu Choh
 */
public class DefaultMethods02 {

    class  S {
        // default methodを定義できない
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
    class Test extends S implements J {
    }
}
