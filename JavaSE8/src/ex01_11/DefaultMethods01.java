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

    // �R���p�C���G���[�ɂȂ�
    class Test implements I, J {
    }
}
