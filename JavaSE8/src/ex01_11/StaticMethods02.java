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

    //�@�R���p�C���G���[�ɂȂ�Ȃ�
    class Test extends S implements J {
    }
}

class S {

    public static void f() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
