package ex01_11;

/**
 *
 * @author Tohtetsu Choh
 */
public class DefaultMethods02 {

    class S {

        // default method���`�ł��Ȃ�

        default public void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    interface J {

        default public void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    // �R���p�C���G���[�ɂȂ�
    class Test extends S implements J {
    }
}
