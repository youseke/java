package ex01_11;

/**
 *
 * @author Tohtetsu Choh
 */
public class AbstractMethods01 {

    interface I {

        public abstract void f();
    }

    interface J {

        public abstract void f();
    }

    // �I�[�o���C�h����΁A���Ȃ������ł���
    class Test implements I, J {

        @Override
        public void f() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }
}
