package ex01_11;

/**
 *
 * @author Tohtetsu Choh
 */
public class StaticMethods01 {

    interface I {

        public static void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    interface J {

        public static void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    //�@�R���p�C���G���[�ɂȂ�Ȃ�
    class Test implements I, J {
    }
}
